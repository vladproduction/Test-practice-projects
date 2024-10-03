package com.vladproduction.junit5springbootpizzadb.entity;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {
    private Pizza pizza;
    private Set<Ingredient> ingredients;

    @BeforeEach
    public void setUp(){
        pizza = new Pizza();
        pizza.setId(1L);
        pizza.setName("Margherita");
        pizza.setDescription("Classic Margherita with fresh basil");
        pizza.setPrice(8.99);

        ingredients = new HashSet<>();
        pizza.setIngredients(ingredients); // Initialize ingredients set
    }

    @Test
    public void getId() {
        assertEquals(Long.valueOf(1L), pizza.getId());
    }

    @Test
    public void getName() {
        assertEquals("Margherita", pizza.getName());
    }

    @Test
    public void getDescription() {
        assertEquals("Classic Margherita with fresh basil", pizza.getDescription());
    }

    @Test
    public void getPrice() {
        assertEquals(Double.valueOf(8.99), pizza.getPrice());
    }

    @Test
    public void getIngredients() {
        // Check that the ingredients set is initially empty
        assertEquals(0, pizza.getIngredients().size());

        // Add an Ingredient to the set and check again
        Ingredient ingredient1 = new Ingredient(1L, "Mozzarella");
        Ingredient ingredient2 = new Ingredient(2L, "Basil leaves");
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        pizza.setIngredients(ingredients);

        assertEquals(2, pizza.getIngredients().size());
    }

    @Test
    public void getPortionSize() {
        // Assuming PortionSize is an enum, we'll set it to a value and test it
        PortionSize portionSize = PortionSize.SMALL; // Assuming SMALL is a valid enum value
        pizza.setPortionSize(portionSize);
        assertEquals(portionSize, pizza.getPortionSize());
    }

    @Test
    public void setId() {
        pizza.setId(2L);
        assertEquals(Long.valueOf(2L), pizza.getId());
    }

    @Test
    public void setName() {
        pizza.setName("Pepperoni");
        assertEquals("Pepperoni", pizza.getName());
    }

    @Test
    public void setDescription() {
        pizza.setDescription("Delicious Pepperoni Pizza");
        assertEquals("Delicious Pepperoni Pizza", pizza.getDescription());
    }

    @Test
    public void setPrice() {
        pizza.setPrice(10.99);
        assertEquals(Double.valueOf(10.99), pizza.getPrice());
    }

    @Test
    public void setIngredients() {
        Set<Ingredient> newIngredients = new HashSet<>();
        Ingredient ingredient = new Ingredient(1L, "Olives");
        newIngredients.add(ingredient);
        pizza.setIngredients(newIngredients);
        assertEquals(newIngredients, pizza.getIngredients());
    }

    @Test
    public void setPortionSize() {
        PortionSize portionSize = PortionSize.HUGE;
        pizza.setPortionSize(portionSize);
        assertEquals(portionSize, pizza.getPortionSize());
    }

    @AfterEach
    public void tearDown(){
        // Clean up after tests
        pizza = null;
        ingredients = null;
    }
}