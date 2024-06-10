package com.adoptionSite.animal_adoption_api.service;

import com.adoptionSite.animal_adoption_api.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class DogImageService {
    private static final String API_URL = "https://api.thedogapi.com/v1/images/search?limit=4";

    @Autowired
    private RestTemplate restTemplate;

    public List<Dog> getRandomDogImageUrl() {
        List<Dog> listOfImages = restTemplate.getForObject(API_URL, ArrayList.class);
        return listOfImages.subList(0, 4);
    }

}
