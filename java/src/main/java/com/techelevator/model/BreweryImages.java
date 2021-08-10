package com.techelevator.model;

public class BreweryImages {

    private int breweryId;
    private String imagePath;

    public BreweryImages() { }

    public BreweryImages(int breweryId, String imagePath) {
        this.breweryId = breweryId;
        this.imagePath = imagePath;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
