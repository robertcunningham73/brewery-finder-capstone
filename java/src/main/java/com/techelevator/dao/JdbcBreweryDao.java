package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.BreweryImages;
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
            brewery.setImages(getImagesByBreweryId(brewery.getBreweryId()));
            breweries.add(brewery);
        }
        return breweries;
    }

    @Override
    public Brewery getBreweryById(int breweryId) {
        Brewery brewery = new Brewery();
            String sql = "Select * FROM breweries b JOIN brewery_images bi ON b.brewery_id = bi.brewery_id WHERE bi.brewery_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);

                if (results.next()) {
                        brewery = mapRowToBrewery(results);
                        brewery.setImages(getImagesByBreweryId(breweryId));
                } else {
                    String sqlElse = "SELECT * FROM breweries WHERE brewery_id = ?;";
                    SqlRowSet resultsElse = jdbcTemplate.queryForRowSet(sqlElse, breweryId);
                    if (resultsElse.next()) {
                        brewery = mapRowToBrewery(resultsElse);
                    }
                }
        return brewery;
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
    public List<BreweryImages> getImagesByBreweryId(int breweryId) {
        List<BreweryImages> imageList = new ArrayList<>();

        String sql = "SELECT brewery_id, brewery_image FROM brewery_images WHERE brewery_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()) {
            BreweryImages image = mapRowToBreweryImages(results);
            imageList.add(image);
        }
        return imageList;
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

    @Override
    public void deleteImageFromBrewery(int breweryId, String imagePath) {
        String sql = "DELETE FROM brewery_images WHERE brewery_id = ? AND brewery_image = ?;";
        jdbcTemplate.update(sql, breweryId, imagePath);
    }

    private Brewery mapRowToBrewery(SqlRowSet rowSet) {
        Brewery brewery = new Brewery();
        brewery.setBreweryId(rowSet.getInt("brewery_id"));
        brewery.setName(rowSet.getString("brewery_name"));
        brewery.setAddress(rowSet.getString("brewery_address"));
        brewery.setCity(rowSet.getString("brewery_city"));
        brewery.setState(rowSet.getString("brewery_state"));
        brewery.setZip(rowSet.getString("brewery_zip"));
        brewery.setPhone(rowSet.getString("brewery_phone"));
        brewery.setEmail(rowSet.getString("brewery_email"));
        brewery.setHistory(rowSet.getString("brewery_history"));
        brewery.setHours(rowSet.getString("brewery_hours"));
        brewery.setBrewerId(rowSet.getInt("brewer_id"));
        brewery.setActive(rowSet.getBoolean("active"));
        return brewery;
    }

    private BreweryImages mapRowToBreweryImages(SqlRowSet rowSet) {
        BreweryImages images = new BreweryImages();
        images.setBreweryId(rowSet.getInt("brewery_id"));
        images.setImagePath(rowSet.getString("brewery_image"));
        return images;
    }
}
