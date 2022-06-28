package com.project.citiesapi.services;

import com.project.citiesapi.entities.State;
import com.project.citiesapi.exceptions.StateNotFound;
import com.project.citiesapi.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    final StateRepository stateRepository;

    public List<State> findAll(){

        return stateRepository.findAll();
    }

    public State findById(Long id) throws StateNotFound{

        return stateRepository.findById(id)
                .orElseThrow(() -> new StateNotFound("State not found for this id = " + id));
    }
}
