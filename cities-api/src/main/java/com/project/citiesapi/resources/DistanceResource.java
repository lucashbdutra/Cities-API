package com.project.citiesapi.resources;

import com.project.citiesapi.services.DistanceService;
import com.project.citiesapi.utils.EarthRadius;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
@RequiredArgsConstructor
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);


    @GetMapping("/by-points") //Vai fazer a conta usando a extensão "earthdistance" e devolver o valor em milhas
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
    }


    @GetMapping("/by-cube") //Vai fazer a conta usando a extensão "cube" e devolver o valor em metros
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(city1, city2));
    }


    @GetMapping("/by-math") //Conta feita "na mão" sem usar as extensões do banco de dados
    public ResponseEntity<Double> byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius unit) {
        log.info("byMath");
        return ResponseEntity.ok().body(service.distanceUsingMath(city1, city2, unit));
    }
}