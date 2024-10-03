package com.vladproduction.junit5springbootpizzadb.service;

import com.vladproduction.junit5springbootpizzadb.entity.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> getPizzas();
    Pizza getPizzaById(Long id);

}
