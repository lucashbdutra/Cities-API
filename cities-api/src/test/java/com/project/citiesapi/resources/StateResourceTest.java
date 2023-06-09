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
import static org.mockito.ArgumentMatchers.anyLong;
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
    private final String UF = "MG";
    private final Integer INDEX = 0;

    private List<State> list;
    private State state;

    @BeforeEach
    public void setUp(){
        Country pais = new Country(1L, "Brazil", "Brasil", "BR", 1058);
        List<Integer> ddd = Arrays.asList(15, 20, 35);

        state = new State(ID, NAME, UF, IBGE, pais, ddd);


        list = List.of(state);
    }

//
//    @Test
//    void shouldReturnAPListWhenCalled() {
//        given(stateService.findAll()).willReturn(list);
//
//        ResponseEntity<List<State>> test = stateResource.findAll();
//
//        assertThat(test).isNotNull();
//        assertThat(test.getBody()).isNotNull();
//
//        assertThat(test).isEqualTo(ResponseEntity.ok().body(list));
//        assertThat(test.getClass()).isEqualTo(ResponseEntity.class);
//        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(list).getStatusCode());
//        assertThat(test.getBody().get(INDEX)).isEqualTo(list.get(INDEX));
//
//        assertThat(test.getBody().get(INDEX).getId()).isEqualTo(list.get(INDEX).getId());
//        assertThat(test.getBody().get(INDEX).getName()).isEqualTo(list.get(INDEX).getName());
//        assertThat(test.getBody().get(INDEX).getUf()).isEqualTo(list.get(INDEX).getUf());
//        assertThat(test.getBody().get(INDEX).getIbge()).isEqualTo(list.get(INDEX).getIbge());
//        assertThat(test.getBody().get(INDEX).getName()).isEqualTo(list.get(INDEX).getName());
//        assertThat(test.getBody().get(INDEX).getCountry()).isEqualTo(list.get(INDEX).getCountry());
//        assertThat(test.getBody().get(INDEX).getDdd()).isEqualTo(list.get(INDEX).getDdd());
//    }
//
//    @Test
//    void shouldReturnAStateWhenALongParameterArePassed(){
//        given(stateService.findById(anyLong())).willReturn(state);
//
//        ResponseEntity<State> test = stateResource.findById(ID);
//
//        assertThat(test).isNotNull();
//        assertThat(test.getBody()).isNotNull();
//
//        assertThat(test).isEqualTo(ResponseEntity.ok().body(state));
//        assertThat(test.getClass()).isEqualTo(ResponseEntity.class);
//        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(state).getStatusCode());
//        assertThat(test.getBody()).isEqualTo(state);
//
//        assertThat(test.getBody().getId()).isEqualTo(state.getId());
//        assertThat(test.getBody().getName()).isEqualTo(state.getName());
//        assertThat(test.getBody().getUf()).isEqualTo(state.getUf());
//        assertThat(test.getBody().getIbge()).isEqualTo(state.getIbge());
//        assertThat(test.getBody().getName()).isEqualTo(state.getName());
//        assertThat(test.getBody().getCountry()).isEqualTo(state.getCountry());
//        assertThat(test.getBody().getDdd()).isEqualTo(state.getDdd());
//    }
}