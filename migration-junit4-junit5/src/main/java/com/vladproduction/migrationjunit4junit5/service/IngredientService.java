package com.vladproduction.migrationjunit4junit5.service;


import com.vladproduction.migrationjunit4junit5.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient findById(Long id);
    Ingredient findByDescription(String description);
    List<Ingredient> getAllIngredients();

}
