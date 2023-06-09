package com.project.citiesapi.services;

import com.project.citiesapi.DTO.CityDTO;
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

    public CityDTO findAll(Pageable pageable){

        Page<City> cities = cityRepository.findAll(pageable);

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCities(cities.getContent());
        cityDTO.setTotalPages(cities.getTotalPages());
        cityDTO.setTotalElements(cities.getTotalElements());
        cityDTO.setPageNumber(cities.getNumber());
        cityDTO.setSize(cities.getSize());

        return cityDTO;
    }

    public City searchCity(String searchTerm) {


        return cityRepository.searchCity(searchTerm.toLowerCase());
    }

}
