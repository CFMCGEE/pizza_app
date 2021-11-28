package com.pizzaorderingapp.details.success;

import com.pizzaorderingapp.model.Pizza;

import java.util.List;

public class SuccessfulPizzaSearch {

    private Integer code;
    private String message;
    private List<Pizza> result;

    public SuccessfulPizzaSearch(Integer code, String message, List<Pizza> result) {

        this.code = code;
        this.message = message;
        this.result = result;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Pizza> getResult() {
        return result;
    }

    public void setResult(List<Pizza> result) {
        this.result = result;
    }

}
