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
public class CatImageService {

    private static final String API_URL = "https://api.thecatapi.com/v1/images/search";
    private static final String API_KEY = "live_Mqtm3DyQbZjWxCZqbFAcyZRieNdmx5UMIgNS0cHjXRdTq204XMWDiBs5Q94EfkS7";

    public String getRandomCatImageUrl() throws IOException {
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

