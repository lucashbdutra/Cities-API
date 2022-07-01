package com.project.citiesapi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringLocationUtilsTest {


    @Test
    public void shouldExtractGeoLocationsFormString() {
        String geoLocation = "(123, 321)";

        Double[] transform = StringLocationUtils.transform(geoLocation);

        assertEquals(123.0, transform[0], "Not equal");
        assertEquals(321, transform[1], "Not equal");
    }
}
