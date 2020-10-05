package edu.miu.sprinmicoservice.microservice.services;


import edu.miu.sprinmicoservice.microservice.domain.City;
import edu.miu.sprinmicoservice.microservice.domain.Country;
import edu.miu.sprinmicoservice.microservice.repostory.CityRepository;
import edu.miu.sprinmicoservice.microservice.repostory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class countries implements Countryservices {
    @Autowired
    private CountryRepository country;
    @Autowired
    private CityRepository city;

    @Override
    public List<Country> getAllcountries() {
        return country.findAll();
    }

    @Override
    public Country getCountryById(int id) {
        if (country.findById(id).isPresent())
            return country.findById(id).get();
        else
            return null;
    }

    @Override
    public List<City> getCityByname(String name) {
        return city.findByCountryName(name);
    }


}
