package com.pizzaorderingapp.service;

import com.pizzaorderingapp.details.success.*;
import com.pizzaorderingapp.exceptions.*;
import com.pizzaorderingapp.model.Pizza;
import com.pizzaorderingapp.repository.PizzaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaService.class);

    @Autowired
    private PizzaRepository pizzaRepository;

    public Object createPizza(Pizza pizza) {

        try {

            Pizza new_pizza = pizzaRepository.save(pizza);

            //SuccessfulCreate successfulCreate = new SuccessfulCreate(HttpStatus.CREATED.value(), "A pizza was successfully created!", new_pizza);

            logger.info("A pizza was successfully created!");
            return new_pizza;

        } catch (PizzaCreateException e) {
            throw new PizzaCreateException();
        }

    }

    public Object getAllPizzas() {

        if (pizzaRepository.findAll().isEmpty()) {
            throw new PizzaGetAllException();
        }

//        SuccessfulRead successfulRead = new SuccessfulRead(HttpStatus.OK.value(),"All pizzas were successfully found!", pizzaRepository.findAll());

        logger.info("All pizzas were successfully found!");
        return pizzaRepository.findAll();

    }

    public Object getPizza(Long id) {

        //SuccessfulSingleRead successfulSingleRead = new SuccessfulSingleRead (HttpStatus.OK.value(), "A pizza was successfully found!",
               // pizzaRepository.findById(id).orElseThrow(PizzaGetOneException::new));

        logger.info("A pizza was successfully found!");
        return pizzaRepository.findById(id).orElseThrow(PizzaGetOneException::new);

    }

    public Object search(String toppings) {

        if (pizzaRepository.findByToppingsLike(toppings).isEmpty()) {
            throw new PizzaGetAllException();
        }

        //SuccessfulPizzaSearch successfulPizzaSearch = new SuccessfulPizzaSearch(HttpStatus.OK.value(),"Here are the pizza(s) with this toppings!", pizzaRepository.findByToppingsLike(toppings));

        logger.info("Here are the pizza(s) with this toppings!");
        return pizzaRepository.findByToppingsLike(toppings);

    }

    public Object updatePizza(Long id, Pizza pizza) {

        Pizza updatingPizza = pizzaRepository.findById(id).orElseThrow(PizzaGetOneException::new);

        updatingPizza.setCrust(pizza.getCrust());
        updatingPizza.setToppings(pizza.getToppings());

        //SuccessfulUpdate successfulUpdate = new SuccessfulUpdate(HttpStatus.OK.value(), "A pizza has been successfully updated!", pizzaRepository.save(pizza));

        logger.info("A pizza has been successfully updated!");
        return pizzaRepository.save(updatingPizza);

    }

    public Object deletePizza(Long id) {

        if (pizzaRepository.findById(id).isEmpty()) {
            throw new PizzaDeleteException();
        }

        pizzaRepository.deleteById(id);

        SuccessfulDelete successfulDelete = new SuccessfulDelete(HttpStatus.ACCEPTED.value(), "The pizza was successfully removed!");

        logger.info("The pizza was successfully removed!");
        return successfulDelete;

    }


}
