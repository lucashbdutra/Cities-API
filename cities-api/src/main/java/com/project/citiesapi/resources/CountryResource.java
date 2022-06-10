package com.project.citiesapi.resources;

import com.project.citiesapi.entities.Country;
import com.project.citiesapi.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryResource {

    public final CountryService countryService;

    @GetMapping //Recebe um parâmetro de "pageable" para filtrar os resultados
    public ResponseEntity<Page<Country>> findAll(Pageable page){
        return ResponseEntity.ok().body(countryService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(countryService.findById(id));
    }
}
