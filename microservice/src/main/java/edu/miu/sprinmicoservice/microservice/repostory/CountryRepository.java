package edu.miu.sprinmicoservice.microservice.repostory;


import edu.miu.sprinmicoservice.microservice.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
