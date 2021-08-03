package com.techelevator.dao;

import com.techelevator.model.Beer;

import java.util.List;

public interface BeerDao {

    List<Beer> getAllBeers();

    Beer getBeerById(int beerId);

    Beer getBeerByName(String name);

    int findIdByName(String name);
}
