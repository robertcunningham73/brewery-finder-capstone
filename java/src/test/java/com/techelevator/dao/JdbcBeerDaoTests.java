package com.techelevator.dao;

import com.techelevator.model.Beer;
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

        sut.update(beer);

        String expected = "test";
        String result = sut.getBeerById(2).getDescription();

        Assert.assertEquals(expected, result);

    }
}