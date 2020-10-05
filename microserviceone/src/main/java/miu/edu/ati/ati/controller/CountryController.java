package miu.edu.ati.ati.controller;

import miu.edu.ati.ati.domain.Country;
import miu.edu.ati.ati.services.Countryservices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController implements CountriesController {
    @Autowired
    private Countryservices countryservice;

    @GetMapping("/countries")
    public List<Country> getAllCounties() {
        return countryservice.getAllcountries();
    }

}
