package com.vladproduction.junit4springbootpizzadb.service.impl;

import com.vladproduction.junit4springbootpizzadb.entity.Pizza;
import com.vladproduction.junit4springbootpizzadb.exceptions.PizzaByIdNotFoundException;
import com.vladproduction.junit4springbootpizzadb.repository.PizzaRepository;
import com.vladproduction.junit4springbootpizzadb.service.PizzaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        log.info("I`m in PizzaService.getPizzaById()...");
        return pizzaRepository.findById(id).orElseThrow(()-> new PizzaByIdNotFoundException("Pizza with id: " + id + " is not found."));
    }
}
