package com.project.citiesapi.resources;

import com.project.citiesapi.entities.State;
import com.project.citiesapi.services.StateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
@RequiredArgsConstructor
public class StateResource {

    final StateService stateService;

    @GetMapping
    @Operation(summary = "Retorna todos os estados do Brasil.")
    public ResponseEntity<List<State>> findAll(){

        return ResponseEntity.ok().body(stateService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um estado brasileiro especifico baseado no seu ID.")
    public ResponseEntity<State> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(stateService.findById(id));
    }
}
