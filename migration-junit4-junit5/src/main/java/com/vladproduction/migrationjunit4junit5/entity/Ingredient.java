package com.vladproduction.migrationjunit4junit5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne // Indicates that many ingredients can belong to one pizza
//    @JoinColumn(name = "pizza_id") // Foreign key column in the ingredient table
    private Pizza pizza; // Reference to the Pizza

    public Ingredient() {
    }

    public Ingredient(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}
