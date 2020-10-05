package miu.edu.ati.ati.services;

import miu.edu.ati.ati.domain.Country;
import miu.edu.ati.ati.repostory.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class countries implements Countryservices {
    @Autowired
    private CountryRepository country;

    @Override
    public List<Country> getAllcountries() {
        return country.findAll();
    }
}
