package com.vladproduction.migrationjunit4junit5.controller;

import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import com.vladproduction.migrationjunit4junit5.service.PizzaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas(){
        List<Pizza> pizzas = pizzaService.getPizzas();
        return new ResponseEntity<>(pizzas, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id){
        return new ResponseEntity<>(pizzaService.getPizzaById(id), OK);
    }

}

