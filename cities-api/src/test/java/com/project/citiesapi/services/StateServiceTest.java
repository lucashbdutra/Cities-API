package com.project.citiesapi.services;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.entities.State;
import com.project.citiesapi.exceptions.CountryNotFound;
import com.project.citiesapi.exceptions.StateNotFound;
import com.project.citiesapi.repositories.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class StateServiceTest {

    @InjectMocks // O "@InjectMocks" não funciona, apenas quando eu injeto realmente a dependencia o teste roda.
    StateService stateService;

    @Mock // Segundo fontes, "@Mock" e "@MockBean" eram pra ser iguais, porém esse teste so funciona com "@MockBean"
    StateRepository stateRepository;

    private final  Long ID = 1L;
    private final Integer IBGE = 156;
    private final String NAME = "TEST";
    private final Integer INDEX = 0;

    private State state;
    private List<State> list;
    private Optional<State> optional;

    @BeforeEach
    public void setUp(){
        Country pais = new Country(1L, "Brazil", "Brasil", "BR", 1058);
        List<Integer> ddd = Arrays.asList(15, 20, 35);

        state = new State(ID, NAME, "MG", IBGE, pais, ddd);

        list = List.of(state);
        optional = Optional.of(state);
    }

    @Test
    void shouldReturnAListOfCitiesWhenTheMethodIsCalled() {
        given(stateRepository.findAll()).willReturn(list);

        List<State> test = stateService.findAll();

        assertThat(test).isEqualTo(list);
        assertThat(test).isNotNull();
        assertThat(test.getClass()).isEqualTo(list.getClass());
        assertThat(test.get(0)).isEqualTo(list.get(0));

        assertThat(test.get(INDEX).getId()).isEqualTo(list.get(INDEX).getId());
        assertThat(test.get(INDEX).getName()).isEqualTo(list.get(INDEX).getName());
        assertThat(test.get(INDEX).getUf()).isEqualTo(list.get(INDEX).getUf());
        assertThat(test.get(INDEX).getIbge()).isEqualTo(list.get(INDEX).getIbge());
        assertThat(test.get(INDEX).getName()).isEqualTo(list.get(INDEX).getName());
        assertThat(test.get(INDEX).getCountry()).isEqualTo(list.get(INDEX).getCountry());
        assertThat(test.get(INDEX).getDdd()).isEqualTo(list.get(INDEX).getDdd());

    }

    @Test
    void shouldReturnAListOfCitiesWhenAIDParameterArePassed(){
        given(stateRepository.findById(anyLong())).willReturn(optional);

        State test = stateService.findById(ID);

        assertThat(test).isEqualTo(state);
        assertThat(test).isNotNull();
        assertThat(test.getClass()).isEqualTo(state.getClass());
        assertThat(test.getId()).isEqualTo(state.getId());

        assertThat(test.getId()).isEqualTo(state.getId());
        assertThat(test.getName()).isEqualTo(state.getName());
        assertThat(test.getUf()).isEqualTo(state.getUf());
        assertThat(test.getIbge()).isEqualTo(state.getIbge());
        assertThat(test.getName()).isEqualTo(state.getName());
        assertThat(test.getCountry()).isEqualTo(state.getCountry());
        assertThat(test.getDdd()).isEqualTo(state.getDdd());
    }

    @Test
    void shouldThrowACountryNotFoundExceptionWhenAEmptyOptionalArePasse(){
        given(stateRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThrows(StateNotFound.class, () -> stateService.findById(ID), "Country not found for this id = " + ID);
    }

}