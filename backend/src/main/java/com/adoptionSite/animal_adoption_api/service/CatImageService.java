package com.adoptionSite.animal_adoption_api.service;


import com.adoptionSite.animal_adoption_api.entity.Cat;
import com.adoptionSite.animal_adoption_api.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class CatImageService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.thecatapi.com/v1/images/search?limit=4";

    public List<Cat> getRandomCatImageUrl() {
        List<Cat> listOfImages = restTemplate.getForObject(API_URL, ArrayList.class);
        return listOfImages.subList(0, 4);
    }
    }


