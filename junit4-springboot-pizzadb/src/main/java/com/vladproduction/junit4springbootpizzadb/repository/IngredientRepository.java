package com.vladproduction.junit4springbootpizzadb.repository;

import com.vladproduction.junit4springbootpizzadb.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByDescription(String description);


}
