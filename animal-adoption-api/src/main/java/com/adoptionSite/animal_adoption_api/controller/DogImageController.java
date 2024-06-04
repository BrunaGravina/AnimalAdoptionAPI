package com.adoptionSite.animal_adoption_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adoptionSite.animal_adoption_api.service.DogImageService;

import java.io.IOException;

@RestController
@RequestMapping("/dogs")
public class DogImageController {
    private final DogImageService dogImageService;

    @Autowired
    public DogImageController(DogImageService dogImageService) {
        this.dogImageService = dogImageService;
    }

    @GetMapping("/random")
    public String getRandomDogImageUrl() throws IOException {
        return dogImageService.getRandomDogImageUrl();
    }

}
