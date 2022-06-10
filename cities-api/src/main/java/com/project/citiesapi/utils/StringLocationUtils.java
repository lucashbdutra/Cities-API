package com.project.citiesapi.utils;

public class StringLocationUtils {

    /**
     * Classe feita para pegar os dados armazenados no atributo geolocation("String")
     * e converte-los para "Double", de forma que possa ser convertido para "Point" posteriormente.
     */
    public static Double[] transform(String geolocation) {
        String result = geolocation.replace("(", "").replace(")", "");
        String[] strings = result.trim().split(",");
        return new Double[] {Double.valueOf(strings[0]), Double.valueOf(strings[1])};
    }
}