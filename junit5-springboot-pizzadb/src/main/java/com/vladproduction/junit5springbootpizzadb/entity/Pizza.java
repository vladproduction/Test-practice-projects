package com.vladproduction.junit5springbootpizzadb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "pizza_ingredient", // Name of the join table
            joinColumns = @JoinColumn(name = "pizza_id"), // Column in the join table for Pizza
            inverseJoinColumns = @JoinColumn(name = "ingredient_id") // Column in the join table for Ingredient
    )
    @JsonManagedReference // This side is the managed reference
    private Set<Ingredient> ingredients = new HashSet<>(); // Set to avoid duplicates

    @Enumerated(value = EnumType.STRING)
    private PortionSize portionSize;

}
