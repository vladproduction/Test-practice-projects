package com.vladproduction.springboottestinglayersh2.services;


import com.vladproduction.springboottestinglayersh2.entity.Product;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Long id);

    Iterable<Product> listAllProducts();
}
