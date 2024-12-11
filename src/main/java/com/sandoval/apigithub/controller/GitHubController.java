package com.sandoval.apigithub.controller;

import com.sandoval.apigithub.dto.GitHubUser;
import com.sandoval.apigithub.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

  private final GitHubService gitHubService;

  @Autowired
  public GitHubController(GitHubService gitHubService) {
    this.gitHubService = gitHubService;
  }

  @GetMapping("/users")
  public List<GitHubUser> searchUsers(@RequestParam String username) {
    return gitHubService.searchUsers(username);
  }
}