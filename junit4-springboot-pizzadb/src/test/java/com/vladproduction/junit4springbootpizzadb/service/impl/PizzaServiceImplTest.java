package com.vladproduction.junit4springbootpizzadb.service.impl;

import com.vladproduction.junit4springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit4springbootpizzadb.entity.Pizza;
import com.vladproduction.junit4springbootpizzadb.entity.PortionSize;
import com.vladproduction.junit4springbootpizzadb.exceptions.PizzaByIdNotFoundException;
import com.vladproduction.junit4springbootpizzadb.repository.PizzaRepository;
import com.vladproduction.junit4springbootpizzadb.service.PizzaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *  for testing the PizzaServiceImplTest class with JUnit 4, we use Mockito to mock the PizzaRepository
 *  and verify the behavior of the service methods;
 *  */
@RunWith(MockitoJUnitRunner.class)
public class PizzaServiceImplTest {

    @Mock
    private PizzaRepository pizzaRepository; //mock repository to have a behaviour

    @InjectMocks
    private PizzaService pizzaService = new PizzaServiceImpl(pizzaRepository); //Instance of the service to testing

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialize mocks
    }

    @After
    public void tearDown() {
        // Any cleanup code if needed
    }

    @Test
    public void getPizzas() {
        // Given
        Set<Ingredient> ingredientsSet1 = new HashSet<>();
        Set<Ingredient> ingredientsSet2 = new HashSet<>();
        Ingredient ingredient1 = new Ingredient(1L, "Tomato");
        Ingredient ingredient2 = new Ingredient(2L, "Cheese");
        Ingredient ingredient3 = new Ingredient(3L, "Bacon");
        Ingredient ingredient4 = new Ingredient(4L, "Mushrooms");
        ingredientsSet1.add(ingredient1);
        ingredientsSet1.add(ingredient2);
        ingredientsSet1.add(ingredient3);
        ingredientsSet2.add(ingredient2);
        ingredientsSet2.add(ingredient3);
        ingredientsSet2.add(ingredient4);

        Pizza pizza1 = new Pizza();
        pizza1.setId(1L);
        pizza1.setName("New York");
        pizza1.setDescription("Classic New York Pizza");
        pizza1.setPrice(10.99);
        pizza1.setPortionSize(PortionSize.MEDIUM);
        pizza1.setIngredients(ingredientsSet1);

        Pizza pizza2 = new Pizza();
        pizza2.setId(2L);
        pizza2.setName("Norway");
        pizza2.setDescription("Classic Norway Pizza");
        pizza2.setPrice(14.99);
        pizza2.setPortionSize(PortionSize.HUGE);
        pizza2.setIngredients(ingredientsSet2);

        when(pizzaRepository.findAll()).thenReturn(Arrays.asList(pizza1, pizza2));

        // When
        List<Pizza> result = pizzaService.getPizzas();

        // Then
        assertEquals(2, result.size());
        assertEquals("New York", result.get(0).getName());
        assertEquals("Norway", result.get(1).getName());
        verify(pizzaRepository).findAll();

    }

    @Test
    public void getPizzaById() {
        // Given: [pizzaId, "Margherita", "Classic Margherita", 8.99, PortionSize.MEDIUM]
        Set<Ingredient> ingredientsSet2 = new HashSet<>();
        Ingredient ingredient2 = new Ingredient(2L, "Cheese");
        Ingredient ingredient3 = new Ingredient(3L, "Bacon");
        Ingredient ingredient4 = new Ingredient(4L, "Mushrooms");
        ingredientsSet2.add(ingredient2);
        ingredientsSet2.add(ingredient3);
        ingredientsSet2.add(ingredient4);
        Long pizzaId = 1L;
        Pizza pizza = new Pizza();
        pizza.setId(pizzaId);
        pizza.setName("Margherita");
        pizza.setDescription("Classic Margherita");
        pizza.setPrice(7.99);
        pizza.setIngredients(ingredientsSet2);
        pizza.setPortionSize(PortionSize.SMALL);
        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.of(pizza));

        // When
        Pizza result = pizzaService.getPizzaById(pizzaId);

        // Then
        assertEquals("Margherita", result.getName());
        verify(pizzaRepository).findById(pizzaId);
    }

    @Test
    public void getPizzaById_notFound() {
        // Given
        Long pizzaId = 4L;
        when(pizzaRepository.findById(pizzaId)).thenReturn(Optional.empty());

        // When & Then
        PizzaByIdNotFoundException exception = assertThrows(
                PizzaByIdNotFoundException.class,
                () -> pizzaService.getPizzaById(pizzaId)
        );
        assertEquals("Pizza with id: " + pizzaId + " is not found.", exception.getMessage());
    }

}