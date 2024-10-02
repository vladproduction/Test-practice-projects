package com.vladproduction.migrationjunit4junit5.service.impl;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import com.vladproduction.migrationjunit4junit5.exceptions.IngredientByDescriptionNotFoundException;
import com.vladproduction.migrationjunit4junit5.exceptions.IngredientByIdNotFoundException;
import com.vladproduction.migrationjunit4junit5.repository.IngredientRepository;
import com.vladproduction.migrationjunit4junit5.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient findById(Long id) {

        return ingredientRepository.findById(id)
                .orElseThrow(()->new IngredientByIdNotFoundException("Ingredient with id: " + id + " is not found."));
    }

    @Override
    public Ingredient findByDescription(String description) {
        return ingredientRepository.findByDescription(description)
                .orElseThrow(()-> new IngredientByDescriptionNotFoundException("Ingredient with description: " + description + " is not found."));
    }
}
