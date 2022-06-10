package com.project.citiesapi.services;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    final CityRepository cityRepository;

    public Page<City> findAll(Pageable page){

        return cityRepository.findAll(page);
    }

    //Pesquisa de cidade usando a query adicionada ao CityRepository
    public City searchCity(String city, Integer uf ){

        return cityRepository.searchCity(city, uf);
    }
}
