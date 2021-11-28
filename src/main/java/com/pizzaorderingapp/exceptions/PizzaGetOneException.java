package com.pizzaorderingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PizzaGetOneException extends RuntimeException {

    public PizzaGetOneException() {

    }

    public PizzaGetOneException(String message) {
        super(message);
    }

    public PizzaGetOneException(String message, Throwable cause) {
        super(message, cause);
    }

}
