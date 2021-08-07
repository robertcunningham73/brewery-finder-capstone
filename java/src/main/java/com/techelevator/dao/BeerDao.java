package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;

import java.util.List;

public interface BeerDao {

    List<Beer> getAllBeers();

    Beer getBeerById(int beerId);

    Beer getBeerByName(String name);

    int findIdByName(String name);

    List<Beer> getBeersByBreweryId(int breweryId);

    public List<Review> getReviewsByBeerId(int beerId);

    public void updateBeer(Beer beer, int breweryId, int beerId);
}
