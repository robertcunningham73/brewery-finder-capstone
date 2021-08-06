package com.techelevator.model;

import java.util.List;

public class Beer {

    private int beerId;
    private String name;
    private String description;
    private double abv;
    private String beerType;
    private String imagePath;
    private List<Review> reviews;

    public Beer() { };

    public Beer(int beerId, String name, String description, double abv, String beerType, String imagePath, List<Review> reviews) {
        this.beerId = beerId;
        this.name = name;
        this.description = description;
        this.abv = abv;
        this.beerType = beerType;
        this.imagePath = imagePath;
        this.reviews = reviews;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) { this.beerId = beerId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getImagePath() { return imagePath; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public List<Review> getReviews() { return reviews; }

    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}
