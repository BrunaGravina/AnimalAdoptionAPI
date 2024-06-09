package com.adoptionSite.animal_adoption_api.controller;

import com.adoptionSite.animal_adoption_api.entity.Cat;
import com.adoptionSite.animal_adoption_api.entity.Dog;
import com.adoptionSite.animal_adoption_api.service.CatImageService;
import com.adoptionSite.animal_adoption_api.service.DogImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/adopt")
public class AdoptionController {
    @Autowired
    private CatImageService catImageService;

    @Autowired
    private DogImageService dogImageService;

    @GetMapping("/dog")
    public List<Dog> getDogsOptions() {
        return dogImageService.getRandomDogImageUrl();
    }

    @GetMapping("/cat")
    public List<Cat> getCatsOptions() {
        return catImageService.getRandomCatImageUrl();
    }
}


