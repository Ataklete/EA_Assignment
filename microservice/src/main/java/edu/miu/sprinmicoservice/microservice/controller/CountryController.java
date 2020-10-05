package edu.miu.sprinmicoservice.microservice.controller;


import edu.miu.sprinmicoservice.microservice.domain.City;
import edu.miu.sprinmicoservice.microservice.domain.Country;
import edu.miu.sprinmicoservice.microservice.services.Countryservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private Countryservices countryservice;

    @GetMapping("/countries")
    public List<Country> getAllCounties() {

        return countryservice.getAllcountries();
    }

    @GetMapping("/countries/{id}")
    public Country getCountryById(@PathVariable int id) {
        return countryservice.getCountryById(id);
    }

    @GetMapping("/cities")
    public List<City> getCountryByname(@RequestParam String country) {
        return countryservice.getCityByname(country);
    }

}
