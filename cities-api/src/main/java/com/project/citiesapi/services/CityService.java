package com.project.citiesapi.services;

import com.project.citiesapi.DTO.CityDTO;
import com.project.citiesapi.entities.City;
import com.project.citiesapi.exceptions.CityNotFound;
import com.project.citiesapi.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    final CityRepository cityRepository;

    public CityDTO findAll(Pageable pageable){

//        PageRequest pageRequest = PageRequest.of(
//                0,
//                10,
//                Sort.Direction.ASC,
//                "name");

        Page<City> cities = cityRepository.findAll(pageable);

        CityDTO citiesDTO = new CityDTO();
        citiesDTO.setCities(cities.getContent());
        citiesDTO.setTotalPages(cities.getTotalPages());
        citiesDTO.setTotalElements(cities.getTotalElements());
        citiesDTO.setPageNumber(cities.getNumber());
        citiesDTO.setSize(cities.getSize());

        return citiesDTO;
    }

    public Page<City> search( String searchTerm, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

        return cityRepository.search(
                searchTerm.toLowerCase(),
                pageRequest);
    }

    public City searchCity(String city, Integer uf ){

        City cityTest = cityRepository.searchCity(city, uf);

        if(cityTest != null){

            return cityTest;

        } else { //Caso a cidade n�o seja encotrada lança a exception personalizada
            throw new CityNotFound("'name' or 'uf' typed are invalid");
        }
    }
}
