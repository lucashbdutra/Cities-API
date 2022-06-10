package com.project.citiesapi.services;

import com.project.citiesapi.CitiesApiApplication;
import com.project.citiesapi.entities.City;
import com.project.citiesapi.repositories.CityRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CityServiceTest {

    @Autowired
    CityService cityService;

    @MockBean
    CityRepository cityRepository;

    private final String NAME = "test";
    private final Long ID = 1L;

    private City ibate;
    private City saoCarlos;
    private List<City> list;
    private Page<City> page;
    private Pageable pageable;

    @BeforeEach
    void setUp(){
        ibate = new City(4929L, "Ibaté", 26, 3519303, "(-21.95840072631836,-47.98820114135742)",
                new Point(-21.95840072631836, -47.98820114135742));
        saoCarlos = new City(5254L, "São Carlos", 26, 3548906, "(-22.01740074157715,-47.88600158691406)",
                new Point(-22.01740074157715, -47.88600158691406));

        list = Arrays.asList(ibate,saoCarlos);

        page = new PageImpl<>(list); // Pra criar uma page

    }

    @Test
    void shouldReturnAPageWhenAPageableParameterArePassed() {
        given(cityRepository.findAll(pageable)).willReturn(page);

        Page<City> test = cityService.findAll(pageable);

        assertThat(test).isEqualTo(page);
        assertThat(test).isNotNull();

    }

    @Test
    void shouldReturnACityWhenANameAndUfArePassed() {
        given(cityRepository.searchCity("ibate", 26)).willReturn(ibate);

        City test = cityService.searchCity("ibate", 26);

        assertThat(test).isEqualTo(ibate);
        assertThat(test).isNotNull();
        assertThat(test.getClass()).isEqualTo(ibate.getClass());
        assertThat(test.getId()).isEqualTo(ibate.getId());
    }
}