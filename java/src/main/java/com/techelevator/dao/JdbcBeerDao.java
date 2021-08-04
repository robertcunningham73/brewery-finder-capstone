package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBeerDao implements BeerDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Beer> getAllBeers() {
        List<Beer> beerList = new ArrayList<>();
        String sql = "SELECT * FROM beer";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beerList.add(beer);
        }
        return beerList;
    }

    @Override
    public Beer getBeerById(int beerId) {
        Beer beer = new Beer();
        String sql = "SELECT * FROM beer WHERE beer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        if(results.next()) {
            return mapRowToBeer(results);
        } else {
            throw new RuntimeException("beerId " + beerId + " was not found.");
        }
    }

    @Override
    public Beer getBeerByName(String name) {
        Beer beer = new Beer();
        String sql = "SELECT * FROM beer WHERE beer_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            return mapRowToBeer(results);
        } else {
            throw new RuntimeException("breweryName " + name + " was not found.");
        }
    }

    @Override
    public int findIdByName(String name) {
        return jdbcTemplate.queryForObject("SELECT beer_id FROM beer WHERE beer_name = ?", int.class, name);
    }

    @Override
    public List<Beer> getBeersByBreweryId(int breweryId) {
        List<Beer> beerList = new ArrayList<>();
        String sql = "SELECT * FROM beer b INNER JOIN beer_inventory bi on b.beer_id = bi.beer_id WHERE bi.brewery_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beerList.add(beer);
        }
        return beerList;
    }

    private Beer mapRowToBeer(SqlRowSet rowSet) {
        Beer beer = new Beer();
        beer.setBeerId(rowSet.getInt("beer_id"));
        beer.setName(rowSet.getString("beer_name"));
        beer.setDescription(rowSet.getString("beer_description"));
        beer.setAbv(rowSet.getDouble("beer_abv"));
        beer.setBeerType(rowSet.getString("beer_type"));
        return beer;
    }
}
