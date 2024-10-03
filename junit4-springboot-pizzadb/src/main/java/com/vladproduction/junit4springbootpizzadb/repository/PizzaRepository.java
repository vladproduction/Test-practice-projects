package com.vladproduction.junit4springbootpizzadb.repository;

import com.vladproduction.junit4springbootpizzadb.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
