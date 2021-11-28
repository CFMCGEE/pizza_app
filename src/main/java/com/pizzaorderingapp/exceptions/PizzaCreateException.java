package com.pizzaorderingapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PizzaCreateException extends RuntimeException {

    public PizzaCreateException() {

    }

    public PizzaCreateException(String message) {
        super(message);
    }

    public PizzaCreateException(String message, Throwable cause) {
        super(message, cause);
    }

}
