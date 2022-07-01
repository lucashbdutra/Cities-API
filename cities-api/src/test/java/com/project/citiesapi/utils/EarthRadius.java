package com.project.citiesapi.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EarthRadius {

    /**
     * Informações para conversão entre milhas, metros e kilometros
     */

    METERS("m", 6378168),
    KILOMETERS("km", 6378.168f),
    MILES("mi", 3958.747716f);

    private final String unit;
    private final float value;

}