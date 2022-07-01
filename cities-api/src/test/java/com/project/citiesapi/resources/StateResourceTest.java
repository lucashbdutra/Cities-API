package com.project.citiesapi.resources;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.entities.State;
import com.project.citiesapi.services.StateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class StateResourceTest {

    @InjectMocks
    StateResource stateResource;

    @Mock
    StateService stateService;

    private final  Long ID = 1L;
    private final Integer IBGE = 156;
    private final String NAME = "TEST";

    private List<State> list;

    @BeforeEach
    public void setUp(){
        Country pais = new Country(1L, "Brazil", "Brasil", "BR", 1058);
        List<Integer> ddd = Arrays.asList(15, 20, 35);

        State estado1 = new State(ID, NAME, "MG", IBGE, pais, ddd);
        State estado2 = new State(ID, NAME, "SP", IBGE, pais, ddd);

        list = Arrays.asList(estado2,estado1);
    }


    @Test
    void findAll() {
        given(stateService.findAll()).willReturn(list);

        ResponseEntity<List<State>> test = stateResource.findAll();

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(list));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(list).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(list).getStatusCode());
        assertThat(test.getBody().get(0)).isEqualTo(ResponseEntity.ok().body(list).getBody().get(0));
        assertThat(test.getBody().get(0).getName()).isEqualTo(ResponseEntity.ok().body(list).getBody().get(0).getName());

    }
}