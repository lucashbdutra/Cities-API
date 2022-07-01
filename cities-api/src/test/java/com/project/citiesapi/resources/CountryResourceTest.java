package com.project.citiesapi.resources;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.services.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CountryResourceTest {

    @InjectMocks
    CountryResource countryResource;

    @Mock
    CountryService countryService;

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
        Country country2 = new Country(ID,NAME,"japao","87",55 );

        list = Arrays.asList(country2,country);
        page = new PageImpl<>(list);
        optional = Optional.of(country2);
    }

    @Test
    void shouldReturnAPageWhenAPageableParameterArePassed(){
        given(countryService.findAll(pageable)).willReturn(page);

        ResponseEntity<Page<Country>> test = countryResource.findAll(pageable);

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(page));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(page).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(page).getStatusCode());

    }

    @Test
    void shouldReturnACountryWhenALongParameterArePassed(){
        given(countryService.findById(Mockito.anyLong())).willReturn(country);

        ResponseEntity<Country> test = countryResource.findById(ID);

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(country));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(country).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(country).getStatusCode());
        assertThat(test.getBody().getId()).isEqualTo(ResponseEntity.ok().body(country).getBody().getId());


    }

}