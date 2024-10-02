package com.vladproduction.migrationjunit4junit5.repository;

import com.vladproduction.migrationjunit4junit5.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
