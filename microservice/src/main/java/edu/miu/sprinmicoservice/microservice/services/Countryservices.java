package edu.miu.sprinmicoservice.microservice.services;


import edu.miu.sprinmicoservice.microservice.domain.City;
import edu.miu.sprinmicoservice.microservice.domain.Country;

import java.util.List;

public interface Countryservices {
    List<Country> getAllcountries();

    Country getCountryById(int id);

    List<City> getCityByname(String name);
}
