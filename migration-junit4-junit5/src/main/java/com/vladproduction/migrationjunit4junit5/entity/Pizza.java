package com.vladproduction.migrationjunit4junit5.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pizza")
    private List<Ingredient> ingredients = new ArrayList<>(); // Initialize the list

    @Enumerated(value = EnumType.STRING)
    private PortionSize portionSize;

}
