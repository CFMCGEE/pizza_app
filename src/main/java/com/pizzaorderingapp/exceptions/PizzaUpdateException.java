package com.pizzaorderingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PizzaUpdateException extends RuntimeException {

    public PizzaUpdateException() {

    }

    public PizzaUpdateException(String message) {
        super(message);
    }

    public PizzaUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

}
