package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryImages;

import java.util.List;

public interface BreweryDao {

    List<Brewery> getAllBreweries();

    Brewery getBreweryById(int breweryId);

    //Brewery getBreweryByName(String name);

    //int findIdByName(String name);

    public void updateBrewery(Brewery brewery);

    public void addBrewery(Brewery brewery);

    public List<BreweryImages> getImagesByBreweryId(int breweryId);

    public void deleteImageFromBrewery(int breweryId, String imagePath);
}
