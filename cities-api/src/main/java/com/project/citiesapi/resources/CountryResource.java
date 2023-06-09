package com.project.citiesapi.resources;

import com.project.citiesapi.DTO.CountryDTO;
import com.project.citiesapi.entities.Country;
import com.project.citiesapi.services.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryResource {

    public final CountryService countryService;

    @GetMapping //Recebe um parâmetro de "pageable" para filtrar os resultados
    @Operation(summary = "Retorna basicamente todos os paises do mundo organizados em uma pagina.")
    public ResponseEntity<CountryDTO> findAll(
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

        return ResponseEntity.ok().body(countryService.findAll(pageRequest));
    }

    @GetMapping("/searchCountry")
    @Operation(summary = "Retorna um pais especifico de acordo com seu nome.")
    public ResponseEntity<Country> findById(@RequestParam("searchTerm") String searchTerm){

        return ResponseEntity.ok().body(countryService.searchCountry(searchTerm));
    }
}
