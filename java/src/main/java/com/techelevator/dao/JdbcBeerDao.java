package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Review;
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
        String sql = "SELECT * FROM beer ORDER BY beer_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beerList.add(beer);
        }
        return beerList;
    }

    @Override
    public Beer getBeerById(int beerId) {
        String sql = "SELECT * FROM beer WHERE beer_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        if(results.next()) {
            Beer beer = mapRowToBeer(results);
            beer.setReviews(getReviewsByBeerId(beerId));
            return beer;
        } else {
            throw new RuntimeException("beerId " + beerId + " was not found.");
        }
    }

    @Override
    public Beer getBeerByName(String name) {
        Beer beer = new Beer();
        String sql = "SELECT * FROM beer WHERE beer_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if(results.next()) {
            return mapRowToBeer(results);
        } else {
            throw new RuntimeException("breweryName " + name + " was not found.");
        }
    }

    @Override
    public int findIdByName(String name) {
        return jdbcTemplate.queryForObject("SELECT beer_id FROM beer WHERE beer_name = ?;", int.class, name);
    }

    @Override
    public List<Beer> getBeersByBreweryId(int breweryId) {
        List<Beer> beerList = new ArrayList<>();
        String sql = "SELECT * FROM beer b INNER JOIN beer_inventory bi on b.beer_id = bi.beer_id WHERE bi.brewery_id = ? ORDER BY b.beer_name;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, breweryId);
        while(results.next()) {
            Beer beer = mapRowToBeer(results);
            beerList.add(beer);
        }
        return beerList;
    }

    @Override
    public List<Review> getReviewsByBeerId(int beerId) {
        List<Review> reviewList = new ArrayList<>();
        String sql = "SELECT br.review_id, br.beer_rating, br.beer_review, u.user_id, u.username FROM beer_reviews br " +
                "JOIN user_reviews ur ON br.review_id = ur.review_id JOIN users u ON ur.user_id = u.user_id " +
                "WHERE br.beer_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beerId);
        while(results.next()) {
            Review review = mapRowToReview(results);
            reviewList.add(review);
        }
        return reviewList;
    }

    private Beer mapRowToBeer(SqlRowSet rowSet) {
        Beer beer = new Beer();
        beer.setBeerId(rowSet.getInt("beer_id"));
        beer.setName(rowSet.getString("beer_name"));
        beer.setDescription(rowSet.getString("beer_description"));
        beer.setAbv(rowSet.getDouble("beer_abv"));
        beer.setBeerType(rowSet.getString("beer_type"));
        beer.setImagePath(rowSet.getString("beer_image"));
        return beer;
    }

    private Review mapRowToReview(SqlRowSet rowSet) {
        Review review = new Review();
        review.setReviewId(rowSet.getInt("review_id"));
        review.setRating(rowSet.getInt("beer_rating"));
        review.setReviewBody(rowSet.getString("beer_review"));
        review.setUserId(rowSet.getInt("user_id"));
        review.setUsername(rowSet.getString("username"));
        return review;
    }
}
