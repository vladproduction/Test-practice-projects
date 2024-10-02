package com.vladproduction.migrationjunit4junit5.service.impl;

import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import com.vladproduction.migrationjunit4junit5.exceptions.PizzaByIdNotFoundException;
import com.vladproduction.migrationjunit4junit5.repository.PizzaRepository;
import com.vladproduction.migrationjunit4junit5.service.PizzaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> getPizzas() {
        log.info("I`m in PizzaService.getPizzas()...");
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(()->new PizzaByIdNotFoundException("Pizza with id: " + id + " is not found."));
    }
}
