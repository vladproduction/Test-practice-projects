package com.vladproduction.junit4springbootpizzadb.service;

import com.vladproduction.junit4springbootpizzadb.entity.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> getPizzas();
    Pizza getPizzaById(Long id);

}
