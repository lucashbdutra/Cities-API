package com.project.citiesapi.resources;

import com.project.citiesapi.entities.State;
import com.project.citiesapi.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateResource {

    final StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> findAll(){

        return ResponseEntity.ok().body(stateService.findAll());
    }
}
