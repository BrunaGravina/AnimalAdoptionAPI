package com.adoptionSite.animal_adoption_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adoptionSite.animal_adoption_api.service.CatImageService;

import java.io.IOException;

@RestController
@RequestMapping("/cats")
public class CatImageController {
    private final CatImageService catImageService;

    @Autowired
    public CatImageController(CatImageService catImageService) {
        this.catImageService = catImageService;
    }

    @GetMapping("/random")
    public String getRandomCatImageUrl() throws IOException {
        return catImageService.getRandomCatImageUrl();
    }
}

