package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    List<Brewery> getAllBreweries();

    Brewery getBreweryById(int breweryId);

    Brewery getBreweryByName(String name);

    int findIdByName(String name);

    public void updateBrewery(Brewery brewery);
}
