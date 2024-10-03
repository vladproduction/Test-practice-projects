package com.vladproduction.junit5springbootpizzadb.repository;

import com.vladproduction.junit5springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit5springbootpizzadb.service.IngredientService;
import com.vladproduction.junit5springbootpizzadb.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IngredientRepositoryTest {

    @Mock
    private IngredientRepository ingredientRepository; // Mocking the IngredientRepository

    @InjectMocks
    private IngredientService ingredientService = new IngredientServiceImpl(ingredientRepository); // Some service that uses IngredientRepository for demonstration

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Any cleanup code if needed
    }

    @Test
    public void findByDescription() {
        // Given
        String description = "Mozzarella";
        Ingredient ingredient = new Ingredient(1L, description);

        // When
        when(ingredientRepository.findByDescription(description)).thenReturn(Optional.of(ingredient));

        // Then
        Optional<Ingredient> result = ingredientRepository.findByDescription(description);
        assertEquals(true, result.isPresent());
        assertEquals("Mozzarella", result.get().getDescription());

        // Verify that the mock was called correctly
        verify(ingredientRepository).findByDescription(description);
    }

    @Test
    public void findByDescription_notFound() {
        // Given
        String description = "NonExistentIngredient";

        // When
        when(ingredientRepository.findByDescription(description)).thenReturn(Optional.empty());

        // Then
        Optional<Ingredient> result = ingredientRepository.findByDescription(description);
        assertEquals(false, result.isPresent());

        // Verify that the mock was called correctly
        verify(ingredientRepository).findByDescription(description);
    }
}