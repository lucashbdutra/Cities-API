package com.project.citiesapi.services;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.exceptions.CountryNotFound;
import com.project.citiesapi.repositories.CountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CountryServiceTest {

    @InjectMocks
    CountryService countryService;

    @Mock
    CountryRepository countryRepository;

    private final Long ID = 1L;
    private final String NAME = "test";

    private Country country;
    private List<Country> list;

    private Page<Country> page;
    private Pageable pageable;
    private Optional<Country> optional;

    @BeforeEach
    void setUp(){

        country = new Country(ID,NAME,"brasil","15",56 );

        list = List.of(country);
        page = new PageImpl<>(list);
        optional = Optional.of(country);


    }

//    @Test
//    void shouldReturnAPageWhenAPageableParameterArePassed() {
//        given(countryRepository.findAll(pageable)).willReturn(page);
//
//        Page<Country> test = countryService.findAll(pageable);
//
//        assertThat(test).isEqualTo(page);
//        assertThat(test).isNotNull();
//        assertThat(test.getClass()).isEqualTo(page.getClass());
//
//    }
//
//    @Test
//    void shouldReturnACountryWhenAIDParameterArePassed() {
//        given(countryRepository.findById(anyLong())).willReturn(optional);
//
//        Country test = countryService.findById(ID);
//
//        assertThat(test).isEqualTo(country);
//        assertThat(test).isNotNull();
//        assertThat(test.getClass()).isEqualTo(country.getClass());
//
//        assertThat(test.getId()).isEqualTo(country.getId());
//        assertThat(test.getName()).isEqualTo(country.getName());
//        assertThat(test.getPortugueseName()).isEqualTo(country.getPortugueseName());
//        assertThat(test.getCode()).isEqualTo(country.getCode());
//        assertThat(test.getBacen()).isEqualTo(country.getBacen());
//    }
//
//    @Test
//    void shouldThrowACountryNotFoundExceptionWhenAEmptyOptionalArePasse(){
//        given(countryRepository.findById(anyLong())).willReturn(Optional.empty());
//
//        assertThrows(CountryNotFound.class, () -> countryService.findById(ID), "Country not found for this id = " + ID);
//    }
}