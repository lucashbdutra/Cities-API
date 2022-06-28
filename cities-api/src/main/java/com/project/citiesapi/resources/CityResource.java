package com.project.citiesapi.resources;

import com.project.citiesapi.entities.City;
import com.project.citiesapi.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityResource {

    public final CityService cityService;

    @GetMapping //Recebe um parâmetro de "pageable" para filtrar os resultados
    @Operation(summary = "Retorna todas as cidades organizadas em uma pagina")
    public ResponseEntity<Page<City>> findAll(Pageable page){

        return ResponseEntity.ok().body(cityService.findAll(page));
    }

    //Usando a query de pesquisa de cidade que foi adiciona no CityRepository
    @GetMapping("/search")
    @Operation(summary = "Busca uma cidade recebendo seu nome e o codigo da sua UF como parametro.") //Coloca uma breve descriçao no endpoint da documentaçao do swagger.
    public ResponseEntity<City> searchCity(@RequestParam Integer uf,
                                           @RequestParam String nome){ //Pensar em mudar para receber a uf por @PathVariable
        return ResponseEntity.ok().body(cityService.searchCity(nome, uf));
    }

}
