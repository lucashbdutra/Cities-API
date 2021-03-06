package com.project.citiesapi.resources;

import com.project.citiesapi.services.DistanceService;
import com.project.citiesapi.utils.EarthRadius;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DistanceResourceTest {

    @InjectMocks
    DistanceResource distanceResource;

    @Mock
    DistanceService distanceService;

    private final Long ID = 1L;
    private final Double NUMBER = 1.0;
    private EarthRadius unit;

    @BeforeEach
    public void setUp() {

    }

    @Test
    void ShouldReturnADistanceBetweenTwoCitiesInMilesWhenTheIdsArePassed() {
        given(distanceService.distanceByPointsInMiles(anyLong(), anyLong())).willReturn(NUMBER);

        ResponseEntity<Double> test = distanceResource.byPoints(ID, ID);

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(NUMBER));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(NUMBER).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(NUMBER).getStatusCode());
    }

    @Test
    void ShouldReturnADistanceBetweenTwoCitiesInMetersWhenTheIdsArePassed() {
        given(distanceService.distanceByCubeInMeters(anyLong(), anyLong())).willReturn(NUMBER);

        ResponseEntity<Double> test = distanceResource.byCube(ID, ID);

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(NUMBER));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(NUMBER).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(NUMBER).getStatusCode());
    }

    @Test
    void ShouldReturnADistanceBetweenTwoCitiesWhenTheIdsAndAUnitArePassed() {
        given(distanceService.distanceUsingMath(ID,ID, unit)).willReturn(NUMBER);

        ResponseEntity<Double> test = distanceResource.byMath(ID, ID, unit);

        assertThat(test).isNotNull();
        assertThat(test).isEqualTo(ResponseEntity.ok().body(NUMBER));
        assertThat(test.getClass()).isEqualTo(ResponseEntity.ok().body(NUMBER).getClass());
        assertThat(test.getStatusCode()).isEqualTo(ResponseEntity.ok().body(NUMBER).getStatusCode());
    }


}
