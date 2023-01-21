package com.project.citiesapi.repositories;

import com.project.citiesapi.entities.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    //Cálculo da distancia entre duas cidades usando a extensão do Postgres earthDistance
    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    //Cálculo da distancia entre duas cidades usando a extensão do Postgres Cube
    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

    //Pesquisa de dados de uma cidade usando o nome e o código do estado.
    @Query(value = "SELECT * FROM cidade WHERE nome=?1 AND uf=?2", nativeQuery = true)
    City searchCity(String city, Integer uf);


    @Query(value = "SELECT * FROM cidade c WHERE LOWER(c.nome) LIKE ?1 ", nativeQuery = true)
    Page<City> search( @Param("searchTerm") String searchTerm, Pageable pageable);


}
