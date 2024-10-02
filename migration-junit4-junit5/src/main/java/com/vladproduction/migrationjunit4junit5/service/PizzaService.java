package com.vladproduction.migrationjunit4junit5.service;

import com.vladproduction.migrationjunit4junit5.entity.Pizza;

import java.util.List;
import java.util.Set;

public interface PizzaService {

    List<Pizza> getPizzas();
    Pizza getPizzaById(Long id);

}
