package com.vladproduction.migrationjunit4junit5.service.impl;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import com.vladproduction.migrationjunit4junit5.exceptions.IngredientByDescriptionNotFoundException;
import com.vladproduction.migrationjunit4junit5.exceptions.IngredientByIdNotFoundException;
import com.vladproduction.migrationjunit4junit5.repository.IngredientRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * for testing the IngredientServiceImpl class with JUnit 4, we use Mockito to mock the IngredientRepository
 * and verify the behavior of the service methods;
 * */
@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceImplTest {
    @Mock
    private IngredientRepository ingredientRepository; // Mocking the IngredientRepository

    @InjectMocks
    private IngredientServiceImpl ingredientService; // Instance of the service to test

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @After
    public void tearDown() {
        // Any cleanup code if needed
    }

    @Test
    public void findById() {
        // Given
        Long ingredientId = 1L;
        Ingredient ingredient = new Ingredient(ingredientId, "Mozzarella");
        when(ingredientRepository.findById(ingredientId)).thenReturn(Optional.of(ingredient));

        // When
        Ingredient result = ingredientService.findById(ingredientId);

        // Then
        assertEquals("Mozzarella", result.getDescription());
        verify(ingredientRepository).findById(ingredientId);
    }

    @Test
    public void findById_notFound() {
        // Given
        Long ingredientId = 2L;
        when(ingredientRepository.findById(ingredientId)).thenReturn(Optional.empty());

        // When & Then
        IngredientByIdNotFoundException exception = assertThrows(
                IngredientByIdNotFoundException.class,
                () -> ingredientService.findById(ingredientId)
        );
        assertEquals("Ingredient with id: " + ingredientId + " is not found.", exception.getMessage());
    }

    @Test
    public void findByDescription() {
        // Given
        String description = "Mozzarella";
        Ingredient ingredient = new Ingredient(1L, description);
        when(ingredientRepository.findByDescription(description)).thenReturn(Optional.of(ingredient));

        // When
        Ingredient result = ingredientService.findByDescription(description);

        // Then
        assertEquals("Mozzarella", result.getDescription());
        verify(ingredientRepository).findByDescription(description);
    }

    @Test
    public void findByDescription_notFound() {
        // Given
        String description = "NonExistentIngredient";
        when(ingredientRepository.findByDescription(description)).thenReturn(Optional.empty());

        // When & Then
        IngredientByDescriptionNotFoundException exception = assertThrows(
                IngredientByDescriptionNotFoundException.class,
                () -> ingredientService.findByDescription(description)
        );
        assertEquals("Ingredient with description: " + description + " is not found.", exception.getMessage());
    }

    @Test
    public void getAllIngredients() {
        // Given
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(1L, "Mozzarella"));
        ingredients.add(new Ingredient(2L, "Tomato"));
        when(ingredientRepository.findAll()).thenReturn(ingredients);

        // When
        List<Ingredient> result = ingredientService.getAllIngredients();

        // Then
        assertEquals(2, result.size());
        assertEquals("Mozzarella", result.get(0).getDescription());
        assertEquals("Tomato", result.get(1).getDescription());
        verify(ingredientRepository).findAll();
    }
}