package com.pizzaorderingapp.details.success;

import com.pizzaorderingapp.model.Pizza;

import java.util.List;

public class SuccessfulDelete {

    private Integer code;
    private String message;

    public SuccessfulDelete(Integer code, String message) {

        this.code = code;
        this.message = message;

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


}
