package com.project.citiesapi.exceptionHandler;

import com.project.citiesapi.exceptions.CityNotFound;
import com.project.citiesapi.exceptions.CountryNotFound;
import com.project.citiesapi.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class) //Aqui eu digo para o spring qual o tipo de exception ser� tratada por esse m�todo, nessa caso s�o todas
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception e, WebRequest request){
        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CityNotFound.class)//Aqui o m�todo vai tratar apenas as CitiNotFound exception
    public final ResponseEntity<ErrorMessage> handleCitiesExceptions(Exception e, WebRequest request){
        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CountryNotFound.class)//Aqui o m�todo vai tratar apenas as CountryNotFound exception
    public final ResponseEntity<ErrorMessage> handleCountryExceptions(Exception e, WebRequest request){
        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}