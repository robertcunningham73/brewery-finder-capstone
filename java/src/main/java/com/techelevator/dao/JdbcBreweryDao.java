package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

//TODO is @Service necessary here like in JdbcUserDao?
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM breweries";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = new Brewery();
        String sql = "Select * FROM breweries WHERE brewery_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        if(results.next()) {
            return mapRowToBrewery(results);
        } else {
            throw new RuntimeException("breweryId " + breweryId + " was not found.");
        }
    }

    @Override
    public Brewery getBreweryByName(String name) {
        Brewery brewery = new Brewery();
        String sql = "Select * FROM breweries WHERE brewery_name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            return mapRowToBrewery(results);
        } else {
            throw new RuntimeException("breweryName " + name + " was not found.");
        }
    }

    @Override
    public int findIdByName(String name) {
        return jdbcTemplate.queryForObject("SELECT brewery_id FROM breweries WHERE brewery_name = ?", int.class, name);
        //TODO implement try/catch for NullPointerEx?
    }

    private Brewery mapRowToBrewery(SqlRowSet rowSet) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rowSet.getInt("brewery_id"));
        brewery.setName(rowSet.getString("brewery_name"));
        brewery.setAddress(rowSet.getString("brewery_address"));
        brewery.setCity(rowSet.getString("brewery_city"));
        brewery.setState(rowSet.getString("brewery_state"));
        brewery.setZip(rowSet.getInt("brewery_zip"));
        brewery.setPhone(rowSet.getInt("brewery_phone"));
        brewery.setEmail(rowSet.getString("brewery_email"));
        brewery.setHistory(rowSet.getString("brewery_history"));
        brewery.setActive(rowSet.getBoolean("active"));
        return brewery;
    }
}