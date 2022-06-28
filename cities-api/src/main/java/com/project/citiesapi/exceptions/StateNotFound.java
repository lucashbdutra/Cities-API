package com.project.citiesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StateNotFound extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public StateNotFound(String message){
        super(message);
    }
}
