package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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
        Beer beer = new Beer();
        beer.setBeerId(2);
        beer.setName("test");
        beer.setDescription("test");
        beer.setAbv(1.1);
        beer.setBeerType("test");
        beer.setImagePath("test");
        sut.update(beer);

        Beer expected = sut.getBeerById(2);
        System.out.println(expected.getName());
    }
}