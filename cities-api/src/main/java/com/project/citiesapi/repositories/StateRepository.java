package com.project.citiesapi.repositories;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    @Query(value = "SELECT * FROM estado e WHERE LOWER(e.nome) LIKE ?1 ", nativeQuery = true)
    State searchState(@Param("searchTerm") String searchTerm);
}
