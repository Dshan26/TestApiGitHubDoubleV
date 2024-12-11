# GitHub User Search API - RESTful Integration

This module integrates with the public GitHub API to search for GitHub users by their username and retrieve detailed profile data. It provides a RESTful endpoint within the application to query the GitHub API and return results in a structured JSON format.

## Features

1. Search for GitHub users by username using the public GitHub API.
2. Retrieve comprehensive user profile data, including login, avatar URL, repositories URL, and more.
3. Expose a RESTful endpoint to query the GitHub API from the application.
4. Handle API rate limits and network errors gracefully.
5. Response includes relevant GitHub user details mapped to custom DTOs.

## Technologies Used

- **Spring Boot**: Framework for building the RESTful service.
- **WebClient**: Spring's reactive client to consume the GitHub API.
- **Java 17**: Programming language.
- **Maven**: Dependency and build management.

## Prerequisites

1. Java 17 or higher.
2. Maven installed.
3. Internet connection to access the GitHub API.

## API Documentation

### Endpoint

- **GET /api/github/users**

#### Query Parameters
- `username` (required): The username or keyword to search for on GitHub.

#### Example Request
```bash
curl -X GET "http://localhost:8080/api/github/users?username=YOUR_NAME"
```

#### Example Response
```json
{
  "total_count": 1,
  "incomplete_results": false,
  "items": [
    {
      "login": "octocat",
      "id": 583231,
      "node_id": "MDQ6VXNlcjU4MzIzMQ==",
      "avatar_url": "https://avatars.githubusercontent.com/u/583231?v=4",
      "html_url": "https://github.com/octocat",
      "repos_url": "https://api.github.com/users/octocat/repos",
      "followers_url": "https://api.github.com/users/octocat/followers",
      "following_url": "https://api.github.com/users/octocat/following{/other_user}",
      "gists_url": "https://api.github.com/users/octocat/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/octocat/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/octocat/subscriptions",
      "organizations_url": "https://api.github.com/users/octocat/orgs",
      "events_url": "https://api.github.com/users/octocat/events{/privacy}",
      "received_events_url": "https://api.github.com/users/octocat/received_events",
      "type": "User",
      "site_admin": false,
      "score": 1.0
    }
  ]
}
```

## DTO Structure

### `GitHubSearchResponse`
Represents the complete response from the GitHub API.

```java
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubSearchResponse {
    private int total_count;
    private boolean incomplete_results;
    private List<GitHubUser> items;

    // Getters and Setters
}
```

### `GitHubUser`
Represents the details of an individual user returned by the API.

```java
@JsonIgnoreProperties(ignoreUnknown = true)
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
    private boolean site_admin;
    private double score;

    // Getters and Setters
}
```

## Error Handling

1. **Invalid or Empty Username**:
   - Returns a `400 Bad Request` with a clear error message.
2. **Rate Limit Exceeded**:
   - If the API rate limit is hit, the application will return a `429 Too Many Requests`.
3. **Network Errors**:
   - Returns a `503 Service Unavailable` if the GitHub API is unreachable.

## Testing the Application

1. Use Postman or `curl` to test the endpoint:
   ```bash
   curl -X GET "http://localhost:9192/api/github/users?username=octocat"
   ```

2. Verify the structure and data in the response.

## Future Enhancements

1. Add support for paginated responses by including `page` and `per_page` parameters.
2. Cache responses to reduce repeated API calls.
3. Extend functionality to include additional GitHub API endpoints, such as repositories or organizations.

---

For any questions or issues, please contact the maintainer of this repository.
