package com.adoptionSite.animal_adoption_api.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class AdoptionImageService {

    public String getCatImage() throws IOException {
        String catApiUrl = "https://api.thecatapi.com/v1/images/search";
        return callAPI(catApiUrl);
    }

    public String getDogImage() throws IOException {
        String dogApiUrl = "https://api.thedogapi.com/v1/images/search";
        return callAPI(dogApiUrl);
    }

    private String callAPI(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}

