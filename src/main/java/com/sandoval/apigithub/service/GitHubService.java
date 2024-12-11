package com.sandoval.apigithub.service;

import com.sandoval.apigithub.dto.GitHubSearchResponse;
import com.sandoval.apigithub.dto.GitHubUser;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class GitHubService {
  private final WebClient webClient;

  public GitHubService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
  }

  public List<GitHubUser> searchUsers(String username) {
    try {
      GitHubSearchResponse response = this.webClient
              .get()
              .uri("/search/users?q={username}", username)
              .retrieve()
              .bodyToMono(GitHubSearchResponse.class)
              .block();

      return response != null ? response.getItems() : List.of();
    } catch (WebClientResponseException e) {
      System.err.println("Error en la llamada al API de GitHub: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
      throw new RuntimeException("Error al buscar usuarios en GitHub: " + e.getMessage(), e);
    } catch (Exception e) {
      System.err.println("Error inesperado al consumir el API de GitHub: " + e.getMessage());
      throw new RuntimeException("Ocurrió un error al buscar usuarios: " + e.getMessage(), e);
    }
  }
}
