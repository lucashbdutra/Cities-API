package com.project.citiesapi.resources;

import com.project.citiesapi.DTO.CityDTO;
import com.project.citiesapi.DTO.StateDTO;
import com.project.citiesapi.entities.City;
import com.project.citiesapi.entities.State;
import com.project.citiesapi.services.StateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
@RequiredArgsConstructor
public class StateResource {

    final StateService stateService;

    @GetMapping
    @Operation(summary = "Retorna todas os estados organizadas em uma pagina")
    public ResponseEntity<StateDTO> findAll(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size){

        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "name");

        return ResponseEntity.ok().body(stateService.findAll(pageRequest));
    }

    @GetMapping("/searchCity")
    public ResponseEntity<State> search(@RequestParam("searchTerm") String searchTerm){

        return ResponseEntity.ok().body(stateService.searchState(searchTerm));
    }
}
