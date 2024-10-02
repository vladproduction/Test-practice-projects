package com.vladproduction.migrationjunit4junit5.repository;

import com.vladproduction.migrationjunit4junit5.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByDescription(String description);


}
