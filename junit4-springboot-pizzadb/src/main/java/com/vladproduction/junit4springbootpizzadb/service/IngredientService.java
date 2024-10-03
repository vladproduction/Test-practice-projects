package com.vladproduction.junit4springbootpizzadb.service;


import com.vladproduction.junit4springbootpizzadb.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);
    Ingredient findByDescription(String description);
    List<Ingredient> getAllIngredients();

}
