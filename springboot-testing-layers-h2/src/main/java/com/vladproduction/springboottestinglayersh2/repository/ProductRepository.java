package com.vladproduction.springboottestinglayersh2.repository;


import com.vladproduction.springboottestinglayersh2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
