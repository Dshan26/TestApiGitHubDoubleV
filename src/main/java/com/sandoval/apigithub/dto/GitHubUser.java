package com.sandoval.apigithub.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GitHubUser {
  private String login;
  private int id;
  private String node_id;
  private String avatar_url;
  private String gravatar_id;
  private String url;
  private String html_url;
  private String followers_url;
  private String following_url;
  private String gists_url;
  private String starred_url;
  private String subscriptions_url;
  private String organizations_url;
  private String repos_url;
  private String events_url;
  private String received_events_url;
  private String type;
  private String user_view_type;
  private boolean site_admin;
  private double score;


}
