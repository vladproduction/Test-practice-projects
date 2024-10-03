package com.vladproduction.migrationjunit4junit5.repository;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import com.vladproduction.migrationjunit4junit5.entity.PortionSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * example of how to implement the PizzaRepositoryTest class with Mockito to verify CRUD operations;
 * using JUnit 4 and Mockito;
 * */
@RunWith(MockitoJUnitRunner.class)
public class PizzaRepositoryTest {
    @Mock
    private PizzaRepository pizzaRepository; // Mocking the PizzaRepository

    // If there's a service that utilizes PizzaRepository, we can inject it here
    // @InjectMocks
    // private PizzaService pizzaService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @After
    public void tearDown() {
        // Any cleanup code if needed
    }

    @Test
    public void testFindById() {
        // Given
        Long pizzaId = 1L;
        Pizza pizza = new Pizza();
        pizza.setId(pizzaId);
        pizza.setName("Margherita");
        pizza.setDescription("Classic Margherita with fresh basil");
        pizza.setPrice(8.99);
        pizza.setPortionSize(PortionSize.MEDIUM);

        // When
        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.of(pizza));

        // Then
        Optional<Pizza> result = pizzaRepository.findById(pizzaId);
        assertEquals(true, result.isPresent());
        assertEquals("Margherita", result.get().getName());

        // Verify that the mock was called correctly
        verify(pizzaRepository).findById(pizzaId);
    }

    @Test
    public void testSave() {
        // Given: null, "Pepperoni", "Classic Pepperoni Pizza", 10.99, PortionSize.MEDIUM
        Pizza pizza = new Pizza();
        pizza.setId(null);
        pizza.setName("Pepperoni");
        pizza.setDescription("Classic Pepperoni Pizza");
        pizza.setPrice(10.99);
        pizza.setPortionSize(PortionSize.MEDIUM);
        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient ingredient1 = new Ingredient(1L, "Pepperoni ingredient");
        Ingredient ingredient2 = new Ingredient(2L, "Cheese");
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        pizza.setIngredients(ingredients);

        // When
        when(pizzaRepository.save(pizza))
                .thenReturn(new Pizza(1L, "Pepperoni", "Classic Pepperoni Pizza", 10.99, ingredients, PortionSize.MEDIUM));

        // Then
        Pizza savedPizza = pizzaRepository.save(pizza);
        assertEquals("Pepperoni", savedPizza.getName());
        assertEquals(Double.valueOf(10.99), savedPizza.getPrice());
        assertTrue(savedPizza.getIngredients().contains(ingredient1));
        assertTrue(savedPizza.getIngredients().contains(ingredient2));

        // Verify that the mock was called correctly
        verify(pizzaRepository).save(pizza);
    }

    @Test
    public void testDelete() {
        // Given
        Long pizzaId = 1L;

        // When
        doNothing().when(pizzaRepository).deleteById(pizzaId);

        // Then
        pizzaRepository.deleteById(pizzaId);

        // Verify that the mock was called correctly
        verify(pizzaRepository).deleteById(pizzaId);
    }

}