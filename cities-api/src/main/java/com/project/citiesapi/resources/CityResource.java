package com.project.citiesapi.resources;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityResource {

    public final CityService cityService;

    @GetMapping //Recebe um parâmetro de "pageable" para filtrar os resultados
    public ResponseEntity<Page<City>> findAll(Pageable page){

        return ResponseEntity.ok().body(cityService.findAll(page));
    }

    //Usando a query de pesquisa de cidade que foi adiciona no CityRepository
    @GetMapping("/search")
    public ResponseEntity<City> searchCity(@RequestParam String nome,
                                           @RequestParam Integer uf){
        return ResponseEntity.ok().body(cityService.searchCity(nome, uf));
    }

}
