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
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //abrindo conexão http com a url específica
        connection.setRequestMethod("GET"); //solicitação get

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //InputStreamReader le o fluxo de entrada da conexão httpd
        String inputLine; // armazena cada linha de entrada
        StringBuilder response = new StringBuilder(); // criando objeto responde onde vai estar a resposta completa

        while ((inputLine = in.readLine()) != null) { // lendo cada linha e anexa ao response até que não tenha mais linhas
            response.append(inputLine);
        }
        in.close();

        return response.toString(); // convertendo response em string antes de retornar
    }
}

