package com.vladproduction.junit5springbootpizzadb.service.impl;

import com.vladproduction.junit5springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit5springbootpizzadb.exceptions.IngredientByDescriptionNotFoundException;
import com.vladproduction.junit5springbootpizzadb.exceptions.IngredientByIdNotFoundException;
import com.vladproduction.junit5springbootpizzadb.repository.IngredientRepository;
import com.vladproduction.junit5springbootpizzadb.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
