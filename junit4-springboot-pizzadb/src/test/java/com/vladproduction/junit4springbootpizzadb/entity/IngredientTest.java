package com.vladproduction.junit4springbootpizzadb.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient ingredient;
    Set<Pizza> pizzas;
    @Before
    public void setUp(){
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setDescription("Mozzarella");
        pizzas = new HashSet<>();
        ingredient.setPizzas(pizzas);
    }

    @Test
    public void getId() {
        assertEquals(Long.valueOf(1L), ingredient.getId());
    }

    @Test
    public void getDescription() {
        assertEquals("Mozzarella", ingredient.getDescription());
    }

    @Test
    public void getPizzas() {
        // Check that the pizzas set is initially empty
        assertEquals(0, ingredient.getPizzas().size());
        // Add a Pizza to the set and check again
        Pizza pizza = new Pizza(); // Assuming a Pizza class exists and has a no-argument constructor
        pizzas.add(pizza);
        ingredient.setPizzas(pizzas);
        assertEquals(1, ingredient.getPizzas().size());
    }

    @Test
    public void setId() {
        ingredient.setId(2L);
        assertEquals(Long.valueOf(2L), ingredient.getId());
    }

    @Test
    public void setDescription() {
        ingredient.setDescription("Mozzarella Extra");
        assertEquals("Mozzarella Extra", ingredient.getDescription());
    }

    @Test
    public void setPizzas() {
        Set<Pizza> newPizzas = new HashSet<>();
        ingredient.setPizzas(newPizzas);
        assertEquals(newPizzas, ingredient.getPizzas());
    }

    @After
    public void tearDown(){
        // Clean up if needed
        ingredient = null;
        pizzas = null;
    }
}