package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebCrawlerForDb implements Runnable {
    private static final int MAX_DEPTH = 3;
    private final String apiEndpoint;
    private final int ID;
    private final Thread thread;
    private final Set<String> visitedUsers = new HashSet<>();

    public WebCrawlerForDb(String apiEndpoint, int num) {
        this.apiEndpoint = apiEndpoint;
        this.ID = num;

        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        collectUserData(apiEndpoint);
    }

    private void collectUserData(String apiUrl) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);
            HttpResponse httpResponse = httpClient.execute(httpGet);

            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println("HTTP Status Code: " + statusCode);

            if (statusCode == 200) {
                System.out.println("ID: " + ID + " Received User Data from API at " + apiUrl);

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(EntityUtils.toString(httpResponse.getEntity()));

                System.out.println("User Data: " + jsonNode);

                visitedUsers.add(apiUrl);
            } else {
                System.out.println("Error: Unexpected HTTP status code " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Thread getThread() {
        return thread;
    }
}


