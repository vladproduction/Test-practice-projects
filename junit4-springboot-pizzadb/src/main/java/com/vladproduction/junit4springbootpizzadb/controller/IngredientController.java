package com.vladproduction.junit4springbootpizzadb.controller;


import com.vladproduction.junit4springbootpizzadb.entity.Ingredient;
import com.vladproduction.junit4springbootpizzadb.service.IngredientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    //ingredients endpoints:
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable Long id){
        Ingredient ingredient = ingredientService.findById(id);
        return new ResponseEntity<>(ingredient, OK);
    }

    //http://localhost:8091/api/ingredients/description?description=bacon
    @GetMapping("/description")
    public ResponseEntity<Ingredient> findByDescription(@RequestParam String description){
        Ingredient ingredient = ingredientService.findByDescription(description);
        return new ResponseEntity<>(ingredient, OK);
    }

    //http://localhost:8091/api/ingredients
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return new ResponseEntity<>(ingredients, OK);
    }
}
