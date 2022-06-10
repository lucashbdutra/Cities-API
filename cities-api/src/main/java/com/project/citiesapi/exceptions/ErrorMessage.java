package com.project.citiesapi.exceptions;

import java.util.Date;

public class ErrorMessage {

    private Date currentDate;
    private String message;

    public ErrorMessage(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }

}
