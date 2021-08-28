package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryImages;

import java.util.List;

public interface BreweryDao {

    public List<Brewery> getAllBreweries();

    public Brewery getBreweryById(int breweryId);

    public Brewery getBreweryByBeerId(int beerId);

    public void updateBrewery(Brewery brewery);

    public void addBrewery(Brewery brewery);

    public List<BreweryImages> getImagesByBreweryId(int breweryId);

    public void deleteImageFromBrewery(int breweryId, String imagePath);
}
