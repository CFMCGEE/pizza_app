package com.pizzaorderingapp.details.success;

import com.pizzaorderingapp.model.Pizza;

public class SuccessfulUpdate {

    private Integer code;
    private String message;
    private Pizza result;

    public SuccessfulUpdate(Integer code, String message, Pizza result) {

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

    public Pizza getResult() {
        return result;
    }

    public void setResult(Pizza result) {
        this.result = result;
    }

}
