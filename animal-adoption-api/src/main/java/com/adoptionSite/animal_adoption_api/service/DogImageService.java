package com.adoptionSite.animal_adoption_api.service;

import com.adoptionSite.animal_adoption_api.entity.Dog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DogImageService {
    private static final String API_URL = "https://api.thedogapi.com/v1/images/search?limit=4";

    @Autowired
    private RestTemplate restTemplate;

    public List<Dog> getRandomDogImageUrl() {
        return restTemplate.getForObject(API_URL, ArrayList.class);
    }

}
