package com.project.citiesapi.DTO;

import com.project.citiesapi.entities.Country;
import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {

    private List<Country> countries;
    private Integer totalPages;
    private Long totalElements;
    private Integer pageNumber;
    private Integer size;
}
