package com.project.citiesapi.resources;

import com.project.citiesapi.DTO.CityDTO;
import com.project.citiesapi.entities.City;
import com.project.citiesapi.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityResource {

    public final CityService cityService;

    @GetMapping
    @Operation(summary = "Retorna todas as cidades organizadas em uma pagina")
    public ResponseEntity<CityDTO> findAll(
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

        return ResponseEntity.ok().body(cityService.findAll(pageRequest));
    }

    @GetMapping("/searchCity")
    public ResponseEntity<City> search(@RequestParam("searchTerm") String searchTerm){

        return ResponseEntity.ok().body(cityService.searchCity(searchTerm));
    }

}
