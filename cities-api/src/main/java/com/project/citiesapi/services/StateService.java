package com.project.citiesapi.services;

import com.project.citiesapi.DTO.StateDTO;
import com.project.citiesapi.entities.State;
import com.project.citiesapi.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StateService {

    final StateRepository stateRepository;

    public StateDTO findAll(Pageable pageable){

        Page<State> states = stateRepository.findAll(pageable);

        StateDTO stateDTO = new StateDTO();
        stateDTO.setStates(states.getContent());
        stateDTO.setTotalPages(states.getTotalPages());
        stateDTO.setTotalElements(states.getTotalElements());
        stateDTO.setPageNumber(states.getNumber());
        stateDTO.setSize(states.getSize());

        return stateDTO;
    }

    public State searchState(String searchTerm) {


        return stateRepository.searchState(searchTerm.toLowerCase());
    }
}
