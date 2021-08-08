package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import com.techelevator.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcBeerDaoTests extends FinalCapstoneDaoTests{

    private JdbcBeerDao sut;

    //TODO finish testing

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBeerDao(jdbcTemplate);
    }

    @Test
    public void updateBeerTest() {
        Review review1 = new Review();
        review1.setReviewId(1);
        review1.setRating(4);
        review1.setReviewBody("test review 1");

        Review review2 = new Review();
        review2.setReviewId(2);
        review2.setRating(1);
        review2.setReviewBody("test review 2");

        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review1);
        reviewList.add(review2);

        Beer beer = new Beer();
        beer.setBeerId(2);
        beer.setName("test");
        beer.setDescription("test");
        beer.setAbv(1.1);
        beer.setBeerType("test");
        beer.setImagePath("test");
        beer.setReviews(reviewList);
        beer.setActive(false);

        //sut.updateBeer(beer, brewery);

        String expected = "test";
        String result = sut.getBeerById(2).getDescription();

        boolean expectedActive = false;
        boolean resultActive = sut.getBeerById(2).isActive();

        Assert.assertEquals(expected, result);
        Assert.assertEquals(expectedActive, resultActive);
    }

    @Test
    public void addBeerTest() {
        Beer beer = new Beer();
        beer.setName("add beer test");
        beer.setDescription("add beer test");
        beer.setAbv(0.0);
        beer.setBeerType("add beer test");
        beer.setActive(false);

        Brewery brewery = new Brewery();
        brewery.setBreweryId(1);

        int expected = sut.getAllBeers().size() + 1;
        int expectedInventory = sut.getBeersByBreweryId(brewery.getBreweryId()).size() + 1;
        sut.addBeer(beer, brewery.getBreweryId());

        int result = sut.getAllBeers().size();
        int resultInventory = sut.getBeersByBreweryId(brewery.getBreweryId()).size();
        Assert.assertEquals(expected, result);
        Assert.assertEquals(expectedInventory, resultInventory);
    }
}