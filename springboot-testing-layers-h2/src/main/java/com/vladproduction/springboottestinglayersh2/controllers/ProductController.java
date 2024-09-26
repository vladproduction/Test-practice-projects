package com.vladproduction.springboottestinglayersh2.controllers;


import com.vladproduction.springboottestinglayersh2.entity.Product;
import com.vladproduction.springboottestinglayersh2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //http://localhost:8090/api/products
    @GetMapping
    public ResponseEntity<Iterable<Product>> listAllProducts(){
        Iterable<Product> products = productService.listAllProducts();
        return new ResponseEntity<>(products, OK);
    }

    //http://localhost:8090/api/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product productById = productService.getProductById(id);
        return new ResponseEntity<>(productById, OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, CREATED);
    }

}
