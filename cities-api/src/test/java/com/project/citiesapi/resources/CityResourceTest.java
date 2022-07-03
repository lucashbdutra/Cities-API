package com.project.citiesapi.resources;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.services.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CityResourceTest {

    @InjectMocks
    CityResource cityResource;

    @Mock
    CityService cityService;

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
        given(cityService.findAll(pageable)).willReturn(page);

        ResponseEntity<Page<City>> test = cityResource.findAll(pageable);

        assertThat(test).isNotNull();
        assertThat(test.getBody()).isNotNull();

        assertThat(test.getClass()).isEqualTo(ResponseEntity.class);
        assertThat(test).isEqualTo(ResponseEntity.ok().body(page));
        assertThat(test.getBody().getClass()).isEqualTo(page.getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(page).getStatusCode());

    }

    @Test
    void shouldReturnACityWhenANameAndUfArePassed() {
        given(cityService.searchCity(any(String.class), any(Integer.class))).willReturn(ibate);

        ResponseEntity<City> test = cityResource.searchCity(26,"ibate");

        assertThat(test).isNotNull();
        assertThat(test.getBody()).isNotNull();

        assertThat(test.getClass()).isEqualTo(ResponseEntity.class);
        assertThat(test).isEqualTo(ResponseEntity.ok().body(ibate));
        assertThat(test.getBody()).isEqualTo(ibate);
        assertThat(test.getBody().getClass()).isEqualTo(ibate.getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(ibate).getStatusCode());

        assertThat(test.getBody().getId()).isEqualTo(ibate.getId());
        assertThat(test.getBody().getName()).isEqualTo(ibate.getName());
        assertThat(test.getBody().getUf()).isEqualTo(ibate.getUf());
        assertThat(test.getBody().getIbge()).isEqualTo(ibate.getIbge());
        assertThat(test.getBody().getGeolocation()).isEqualTo(ibate.getGeolocation());
        assertThat(test.getBody().getLocation()).isEqualTo(ibate.getLocation());
    }
}