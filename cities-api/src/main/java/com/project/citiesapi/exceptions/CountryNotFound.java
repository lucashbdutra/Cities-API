package com.project.citiesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFound extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public CountryNotFound(String exception){
        super(exception); // A mensagem recebida aqui, vai passar de construtor em construtor das classes m�e at�
        // chegar na Trowable, onde ela vai ser colocada no detalhe da exception que vai ser apresentada ao usu�rio.
    }
}