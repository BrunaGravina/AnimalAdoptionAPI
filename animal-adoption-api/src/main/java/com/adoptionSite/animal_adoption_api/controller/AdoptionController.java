package com.adoptionSite.animal_adoption_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adoptionSite.animal_adoption_api.service.AdoptionImageService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdoptionController {
    @Autowired
    private AdoptionImageService animalImageService;

    @GetMapping("/adopt")
    public List<String> getAdoptPage() throws IOException {
        List<String> images = new ArrayList<>();

        // duas imagens de gato
        for (int i = 0; i < 2; i++) {
            String catImage = animalImageService.getCatImage();
            images.add(catImage);
        }

        // duas imagens de cachorro
        for (int i = 0; i < 2; i++) {
            String dogImage = animalImageService.getDogImage();
            images.add(dogImage);
        }

        return images;
    }
}


