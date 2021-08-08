package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT * FROM breweries ORDER BY brewery_name";

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
    public void addBrewery(Brewery brewery) {
        String sql = "INSERT into breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, " +
                "brewery_phone, brewery_email, brewery_hours, brewery_history, brewer_id, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, brewery.getName(), brewery.getAddress(), brewery.getCity(), brewery.getState(),
                brewery.getZip(), brewery.getPhone(), brewery.getEmail(), brewery.getHours(), brewery.getHistory(), brewery.getBrewerId(),
                brewery.isActive());

    }

    @Override
    public int findIdByName(String name) {
        return jdbcTemplate.queryForObject("SELECT brewery_id FROM breweries WHERE brewery_name = ?", int.class, name);
        //TODO implement try/catch for NullPointerEx?
    }

    @Override
    public void updateBrewery(Brewery brewery) {
        String sql = "UPDATE breweries SET brewery_name = ?, brewery_address = ?, brewery_city = ?, brewery_state = ?, " +
                "brewery_zip = ?, brewery_phone = ?, brewery_email = ?, brewery_hours = ?, brewery_history = ?, brewer_id = ?, active = ? " +
                "WHERE brewery_id = ?;";
        jdbcTemplate.update(sql, brewery.getName(), brewery.getAddress(), brewery.getCity(), brewery.getState(),
                brewery.getZip(), brewery.getPhone(), brewery.getEmail(), brewery.getHours(), brewery.getHistory(), brewery.getBrewerId(),
                brewery.isActive(), brewery.getBreweryId());
    }

    private Brewery mapRowToBrewery(SqlRowSet rowSet) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rowSet.getInt("brewery_id"));
        brewery.setName(rowSet.getString("brewery_name"));
        brewery.setAddress(rowSet.getString("brewery_address"));
        brewery.setCity(rowSet.getString("brewery_city"));
        brewery.setState(rowSet.getString("brewery_state"));
        brewery.setZip(rowSet.getInt("brewery_zip"));
        brewery.setPhone(rowSet.getString("brewery_phone"));
        brewery.setEmail(rowSet.getString("brewery_email"));
        brewery.setHours(rowSet.getString("brewery_hours"));
        brewery.setHistory(rowSet.getString("brewery_history"));
        brewery.setBrewerId(rowSet.getInt("brewer_id"));
        brewery.setActive(rowSet.getBoolean("active"));
        return brewery;
    }
}
