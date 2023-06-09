package com.project.citiesapi.repositories;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT * FROM pais p WHERE LOWER(p.nome_pt) LIKE ?1 ", nativeQuery = true)
    Country searchCountry(@Param("searchTerm") String searchTerm);
}
