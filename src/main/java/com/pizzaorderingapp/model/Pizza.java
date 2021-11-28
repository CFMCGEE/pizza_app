package com.pizzaorderingapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crust;

//    @ElementCollection
//    @CollectionTable(name = "pizza_toppings", joinColumns = @JoinColumn(name = "id"))
    private String toppings;

    public Pizza(Long id, String crust, String toppings) {

        this.id = id;
        this.crust = crust;
        this.toppings = toppings;

    }

    public Pizza() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

}
