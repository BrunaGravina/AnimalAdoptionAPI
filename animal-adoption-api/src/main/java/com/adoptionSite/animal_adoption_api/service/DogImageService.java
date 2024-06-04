package com.adoptionSite.animal_adoption_api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DogImageService {
    private static final String API_URL = "https://api.thedogapi.com/v1/images/search";
    private static final String API_KEY = "live_HyxHkP30DqC8v9pZ4ROSP7REL0YyD2h1XOKe8dtHHk5MpFXkaRZlv9kJgX1gL6dY";

    public String getRandomDogImageUrl() throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL + "?api_key=" + API_KEY);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.getEntity().getContent());
                return jsonNode.get(0).get("url").asText();
            }
        }
    }
}
