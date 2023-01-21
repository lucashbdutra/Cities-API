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

    @GetMapping //Recebe um parâmetro de "pageable" para filtrar os resultados
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

    @GetMapping("/search")
    public ResponseEntity<Page<City>> search(
            @RequestParam("searchTerm") String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return ResponseEntity.ok().body(cityService.search(searchTerm, page, size));
    }


//    @GetMapping("/search")
//    @Operation(summary = "Busca uma cidade recebendo seu nome e o codigo da sua UF como parametro.") //Coloca uma breve descriçao no endpoint da documentaçao do swagger.
//    public ResponseEntity<City> searchCity(@RequestParam Integer uf,
//                                           @RequestParam String nome){ //Pensar em mudar para receber a uf por @PathVariable
//        return ResponseEntity.ok().body(cityService.searchCity(nome, uf));
//    }

}
