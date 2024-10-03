package com.vladproduction.junit5springbootpizzadb.controller;

import com.vladproduction.junit5springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit5springbootpizzadb.service.IngredientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * we use Mockito to mock the IngredientService and then use Spring's MockMvc to test the controller endpoints;
 * */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IngredientService ingredientService;

    @InjectMocks
    private IngredientController ingredientController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @AfterEach
    public void tearDown(){
        // Any cleanup code if needed
    }

    @Test
    public void findById() throws Exception {
        // Given
        Long id = 1L;
        Ingredient ingredient = new Ingredient(id, "Mozzarella");
        when(ingredientService.findById(id)).thenReturn(ingredient);

        // When & Then
        mockMvc.perform(get("/api/ingredients/{id}", id) //path variable
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Mozzarella"));
    }

    @Test
    public void findByDescription() throws Exception {
        // Given
        String description = "Mozzarella";
        Ingredient ingredient = new Ingredient(1L, description);
        when(ingredientService.findByDescription(description)).thenReturn(ingredient);

        // When & Then
        mockMvc.perform(get("/api/ingredients/description") //request param
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("description", ingredient.getDescription())
                        .content("\"" + description + "\"")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Mozzarella"));
    }

    @Test
    public void getAllIngredients() throws Exception{
        // Given
        Ingredient ingredient1 = new Ingredient(1L, "Mozzarella");
        Ingredient ingredient2 = new Ingredient(2L, "Tomato");
        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);
        when(ingredientService.getAllIngredients()).thenReturn(ingredients);

        // When & Then
        mockMvc.perform(get("/api/ingredients") //simple get by the base URL
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("Mozzarella"))
                .andExpect(jsonPath("$[1].description").value("Tomato"));
    }

}