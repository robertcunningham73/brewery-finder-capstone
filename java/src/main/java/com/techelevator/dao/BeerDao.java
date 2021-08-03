package com.techelevator.dao;

import java.util.List;

public interface BeerDao {

    List<BeerDao> getAllBeers();

    BeerDao getBeerById(int beerId);

    BeerDao getBeerByName(String name);

    int findIdByName(String name);
}
