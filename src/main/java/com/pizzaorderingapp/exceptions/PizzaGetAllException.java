package com.pizzaorderingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PizzaGetAllException extends RuntimeException {

    public PizzaGetAllException() {

    }

    public PizzaGetAllException(String message) {
        super(message);
    }

    public PizzaGetAllException(String message, Throwable cause) {
        super(message, cause);
    }

}
