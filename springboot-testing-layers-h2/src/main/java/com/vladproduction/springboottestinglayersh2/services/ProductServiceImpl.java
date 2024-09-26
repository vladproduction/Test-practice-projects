package com.vladproduction.springboottestinglayersh2.services;


import com.vladproduction.springboottestinglayersh2.entity.Product;
import com.vladproduction.springboottestinglayersh2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }
}
