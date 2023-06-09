package com.project.citiesapi.DTO;

import com.project.citiesapi.entities.State;
import lombok.Data;

import java.util.List;

@Data
public class StateDTO {

    private List<State> states;
    private Integer totalPages;
    private Long totalElements;
    private Integer pageNumber;
    private Integer size;
}
