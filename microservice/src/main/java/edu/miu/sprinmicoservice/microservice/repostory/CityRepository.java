package edu.miu.sprinmicoservice.microservice.repostory;


import edu.miu.sprinmicoservice.microservice.domain.City;
import edu.miu.sprinmicoservice.microservice.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    //   @Query("from City c where c.country.name = :name ")
    List<City> findByCountryName(String name);
}
