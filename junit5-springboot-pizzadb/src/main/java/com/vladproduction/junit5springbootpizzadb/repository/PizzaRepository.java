package com.vladproduction.junit5springbootpizzadb.repository;

import com.vladproduction.junit5springbootpizzadb.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
