package com.pizzaorderingapp.controller;

import com.pizzaorderingapp.model.Pizza;
import com.pizzaorderingapp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("/orders")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Object> makePizza(@Valid @RequestBody Pizza pizza){

        URI newPizzaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pizza.getId()).toUri();

        return ResponseEntity.created(newPizzaUri).body(pizzaService.createPizza(pizza));

    }

    @GetMapping
    public ResponseEntity<Object> retrieveAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieveAPizza(@PathVariable Long id) {
        return ResponseEntity.ok(pizzaService.getPizza(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Object> retrieveByToppings(@RequestParam("toppings") String toppings) {
        return ResponseEntity.ok(pizzaService.search(toppings));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editPizza(@PathVariable Long id, @Valid @RequestBody Pizza pizza) {
        return ResponseEntity.ok(pizzaService.updatePizza(id, pizza));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removePizza(@PathVariable Long id) {
        return ResponseEntity.accepted().body(pizzaService.deletePizza(id));
    }

}
