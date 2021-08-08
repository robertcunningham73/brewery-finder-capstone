package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BreweryController {

    private BreweryDao breweryDao;

    public BreweryController(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    @RequestMapping(path="/breweries", method = RequestMethod.GET)
    public List<Brewery> list() {
        return breweryDao.getAllBreweries();
    }

    @RequestMapping(path="/breweries/{id}", method = RequestMethod.GET)
    public Brewery get(@PathVariable int id) { return breweryDao.getBreweryById(id); }

    @RequestMapping(path="/breweries/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Brewery brewery, @PathVariable int id) { breweryDao.updateBrewery(brewery); }

    @RequestMapping(path="/breweries", method = RequestMethod.POST)
    public void add(@RequestBody Brewery brewery) { breweryDao.addBrewery(brewery); }

}
