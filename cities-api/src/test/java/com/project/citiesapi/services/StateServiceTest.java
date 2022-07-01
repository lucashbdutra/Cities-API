package com.project.citiesapi.services;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.entities.State;
import com.project.citiesapi.repositories.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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

    private List<State> list;
    private Optional<State> optional;

    @BeforeEach
    public void setUp(){
        Country pais = new Country(1L, "Brazil", "Brasil", "BR", 1058);
        List<Integer> ddd = Arrays.asList(15, 20, 35);

        State estado1 = new State(ID, NAME, "MG", IBGE, pais, ddd);
        State estado2 = new State(ID, NAME, "SP", IBGE, pais, ddd);

        list = Arrays.asList(estado2,estado1);
        optional = Optional.of(estado1);
    }

    @Test
    void shouldReturnAListOfCitiesWhenTheMethodIsCalled() {
        given(stateRepository.findAll()).willReturn(list);

        List<State> test = stateService.findAll();

        assertThat(test).isEqualTo(list);
        assertThat(test).isNotNull();
        assertThat(test.getClass()).isEqualTo(list.getClass());
        assertThat(test.get(0)).isEqualTo(list.get(0));

    }

    @Test
    void shouldReturnAListOfCitiesWhenAIDParameterArePassed(){
        given(stateRepository.findById(Mockito.anyLong())).willReturn(optional);

        State test = stateService.findById(ID);

        assertThat(test).isEqualTo(optional.get());
        assertThat(test).isNotNull();
        assertThat(test.getClass()).isEqualTo(optional.get().getClass());
        assertThat(test.getId()).isEqualTo(optional.get().getId());
    }
}