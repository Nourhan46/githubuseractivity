# GitHub User Repositories CLI 

A lightweight, command-line interface (CLI) application built in Java that fetches and displays the public repositories of any GitHub user. 

This project uses Java's built-in `HttpClient` (Java 11+) to make HTTP requests to the GitHub REST API and `Gson` to parse the JSON response.

##  Features

- Fetch a list of public repositories for a specific GitHub username.
- Clean and simple terminal output.
- Built-in error handling (User not found, Rate limit exceeded, etc.).
- Uses modern Java features (Java 11+ `HttpClient`).

##  Prerequisites

Before running this project, make sure you have:
- **Java JDK 11** or higher installed.
- **Maven** or **Gradle** (if you are building from source, to resolve the Gson dependency).


   ```bash
   git clone https://github.com/Nourhan46/githubuseractivity.git
   cd github-user-repos
