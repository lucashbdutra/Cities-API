package com.project.citiesapi.DTO;

import com.project.citiesapi.entities.City;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
public class CityDTO {

    private List<City> cities;
    private Integer totalPages;
    private Long totalElements;
    private Integer pageNumber;
    private Integer size;

}
