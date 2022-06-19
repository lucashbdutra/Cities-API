package com.project.citiesapi.exceptions;

import java.util.Date;

public class ErrorMessage {

    private Date currentDate;
    private String message;
    private String details;

    public ErrorMessage(Date currentDate, String message, String details) {
        this.currentDate = currentDate;
        this.message = message;
        this.details = details;
    }

}
