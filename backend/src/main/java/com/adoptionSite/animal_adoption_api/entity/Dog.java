package com.adoptionSite.animal_adoption_api.entity;

import java.util.List;

public class Dog {
    private String id;
    private String url;
    private Double width;
    private Double height;
    private List<Cat> breeds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<Cat> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Cat> breeds) {
        this.breeds = breeds;
    }
}
