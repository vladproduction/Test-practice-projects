package com.vladproduction.migrationjunit4junit5.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pizza")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private PortionSize portionSize;

    public Pizza addIngredient(Ingredient ingredient){
        ingredient.setPizza(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
