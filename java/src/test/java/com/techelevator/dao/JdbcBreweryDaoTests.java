package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcBreweryDaoTests extends FinalCapstoneDaoTests{

    private JdbcBreweryDao sut;

    //TODO finish testing

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(jdbcTemplate);
    }

    @Test
    public void getAllBreweriesTest() {
        List<Brewery> breweries = sut.getAllBreweries();
        int expected = 4;

        int result = breweries.size();

        Assert.assertEquals(expected, result);
    }
}
