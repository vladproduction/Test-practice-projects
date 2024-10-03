package com.vladproduction.junit5springbootpizzadb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "ingredients") // Inverse side of the relationship
    @JsonBackReference // This side is the back reference
    private Set<Pizza> pizzas = new HashSet<>(); //Reference back to pizza

    public Ingredient() {
    }

    public Ingredient(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}
