package com.pizzaorderingapp.exceptionhandler;

import com.pizzaorderingapp.details.error.ProblemInCode;
import com.pizzaorderingapp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PizzaExceptionHandler extends PizzaGetAllException {

    @ExceptionHandler(PizzaGetOneException.class)
    public ResponseEntity<?> handlePizzaGetOneException() {
        ProblemInCode error = new ProblemInCode("No pizza found.");
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PizzaGetAllException.class)
    public ResponseEntity<?> handlePizzaGetAllException() {
        ProblemInCode error = new ProblemInCode("No pizzas found.");
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PizzaCreateException.class)
    public ResponseEntity<?> handlePizzaCreateException() {
        ProblemInCode error = new ProblemInCode("Unable to make a pizza");
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PizzaUpdateException.class)
    public ResponseEntity<?> handlePizzaUpdateException() {
        ProblemInCode error = new ProblemInCode("Unable to update the pizza since it doesn't exist.");
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PizzaDeleteException.class)
    public ResponseEntity<?> handlePizzaDeleteException() {
        ProblemInCode error = new ProblemInCode("Unable to delete the pizza since it doesn't exist.");
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

}
