package com.project.citiesapi.services;

import com.project.citiesapi.DTO.CountryDTO;
import com.project.citiesapi.entities.Country;
import com.project.citiesapi.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    public final CountryRepository countryRepository;

    public CountryDTO findAll(Pageable pageable){

        Page<Country> countries = countryRepository.findAll(pageable);

        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountries(countries.getContent());
        countryDTO.setTotalPages(countries.getTotalPages());
        countryDTO.setTotalElements(countries.getTotalElements());
        countryDTO.setPageNumber(countries.getNumber());
        countryDTO.setSize(countries.getSize());

        return countryDTO;
    }

    public Country searchCountry( String searchTerm) {

        return countryRepository.searchCountry(searchTerm.toLowerCase());
    }

}
