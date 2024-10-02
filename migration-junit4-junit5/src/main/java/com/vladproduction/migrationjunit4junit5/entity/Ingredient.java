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

    @ManyToOne
    private Pizza pizza;

    public Ingredient() {
    }

    public Ingredient(Long id, String description) {
        this.id = id;
        this.description = description;
    }

}
