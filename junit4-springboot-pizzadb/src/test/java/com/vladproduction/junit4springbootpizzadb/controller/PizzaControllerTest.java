package com.vladproduction.junit4springbootpizzadb.controller;

import com.vladproduction.junit4springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit4springbootpizzadb.entity.Pizza;
import com.vladproduction.junit4springbootpizzadb.service.PizzaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.vladproduction.junit4springbootpizzadb.entity.PortionSize.HUGE;
import static com.vladproduction.junit4springbootpizzadb.entity.PortionSize.MEDIUM;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * we use Mockito to mock the PizzaService and then use Spring's MockMvc to test the controller endpoints;
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PizzaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private PizzaService pizzaService;
    @InjectMocks
    private PizzaController pizzaController;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pizzaController).build();
    }

    @After
    public void tearDown() {
        // Any cleanup code if needed
    }

    @Test
    public void getPizzas() throws Exception {
        //Given
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
        pizza1.setPortionSize(MEDIUM);
        pizza1.setIngredients(ingredientsSet1);

        Pizza pizza2 = new Pizza();
        pizza2.setId(2L);
        pizza2.setName("Norway");
        pizza2.setDescription("Classic Norway Pizza");
        pizza2.setPrice(14.99);
        pizza2.setPortionSize(HUGE);
        pizza2.setIngredients(ingredientsSet2);

        when(pizzaService.getPizzas()).thenReturn(Arrays.asList(pizza1, pizza2));

        //When & Then
        mockMvc.perform(get("/api/pizzas")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())

                //pizza [0: New York]
                .andExpect(jsonPath("$[0].name").value("New York"))
                .andExpect(jsonPath("$[0].description").value("Classic New York Pizza"))
                .andExpect(jsonPath("$[0].price").value(10.99))
                .andExpect(jsonPath("$[0].portionSize").value(String.valueOf(MEDIUM)))
                //ingredients
                // Check that pizza1 contains "Cheese", "Tomato" and "Bacon"
                .andExpect(jsonPath("$[0].ingredients[*].description").value(hasItem("Tomato")))
                .andExpect(jsonPath("$[0].ingredients[*].description").value(hasItem("Cheese")))
                .andExpect(jsonPath("$[0].ingredients[*].description").value(hasItem("Bacon")))

                //pizza [1: Norway]
                .andExpect(jsonPath("$[1].name").value("Norway"))
                .andExpect(jsonPath("$[1].description").value("Classic Norway Pizza"))
                .andExpect(jsonPath("$[1].price").value(14.99))
                .andExpect(jsonPath("$[1].portionSize").value(String.valueOf(HUGE)))
                //ingredients
                .andExpect(jsonPath("$[1].ingredients[*].description").value(hasItem("Cheese")))
                .andExpect(jsonPath("$[1].ingredients[*].description").value(hasItem("Bacon")))
                .andExpect(jsonPath("$[1].ingredients[*].description").value(hasItem("Mushrooms")));
    }

    @Test
    public void getPizzaById() throws Exception{
        //Given
        Ingredient ingredient1 = new Ingredient(1L, "Tomato");
        Ingredient ingredient2 = new Ingredient(2L, "Cheese");
        Ingredient ingredient3 = new Ingredient(3L, "Mushrooms");
        Set<Ingredient> ingredientSet = new HashSet<>(List.of(ingredient1, ingredient2, ingredient3));
        Pizza pizza = new Pizza();
        Long pizzaId = 1L;
        pizza.setId(pizzaId);
        pizza.setName("Toronto");
        pizza.setDescription("Traditional Toronto Pizza");
        pizza.setPrice(15.99);
        pizza.setIngredients(ingredientSet);
        pizza.setPortionSize(HUGE);

        when(pizzaService.getPizzaById(pizzaId)).thenReturn(pizza);

        //When & Then
        mockMvc.perform(get("/api/pizzas/{id}", pizzaId) //path variable
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pizzaId))
                .andExpect(jsonPath("$.name").value("Toronto"))
                .andExpect(jsonPath("$.description").value("Traditional Toronto Pizza"))
                .andExpect(jsonPath("$.price").value(15.99))
                .andExpect(jsonPath("$.ingredients[*].description").value(hasItem("Tomato")))
                .andExpect(jsonPath("$.ingredients[*].description").value(hasItem("Cheese")))
                .andExpect(jsonPath("$.ingredients[*].description").value(hasItem("Mushrooms")))
                .andExpect(jsonPath("$.portionSize").value(String.valueOf(HUGE)));
    }
}