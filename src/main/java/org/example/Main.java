package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: github-activity <username>");
            System.exit(1);
        }

        try {
            fetchAndDisplay(args[0]);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
     static  void fetchAndDisplay(String username) throws IOException, InterruptedException {
         HttpClient client = HttpClient.newHttpClient();
         String url = String.format("https://api.github.com/users/%s/repos?per_page=3", username);
         System.out.println(url);
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(url))
                 .build();
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         switch (response.statusCode()) {
             case 200:
                 formatResponse(response.body());
                 break;
             case 404:
                 System.err.println("User '" + username + "' not found.");
                 break;
             case 403:
                 System.err.println("Rate limit exceeded or forbidden.");
                 break;
             default:
                 System.err.println("GitHub API error: HTTP " + response.statusCode());
                 break;
         }


     }
       static void formatResponse(String body){
           JsonArray repos = JsonParser.parseString(body).getAsJsonArray();
        for(int i=0;i< repos.size();i++)
        {
            JsonObject repo = repos.get(i).getAsJsonObject();
            String name= repo.get("name").getAsString();
            System.out.println(name);
        }



        }

}