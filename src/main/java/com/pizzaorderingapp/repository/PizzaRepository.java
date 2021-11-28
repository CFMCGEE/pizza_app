package com.pizzaorderingapp.repository;

import com.pizzaorderingapp.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findByToppingsLike(String toppings);

}
