package com.vladproduction.springboottestinglayersh2.services;

import com.vladproduction.springboottestinglayersh2.entity.Product;
import com.vladproduction.springboottestinglayersh2.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Unit tests for the ProductService class.
 *
 * This test class is annotated with {@code @SpringBootTest} to load the full
 * application context and allows for autowiring of the {@link ProductRepository}
 * and {@link ProductService} components. It also sets up a sample product for
 * testing various service methods.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    private Product sampleProduct;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

        sampleProduct = new Product();
        sampleProduct.setName("Sample Product");
        sampleProduct.setDescription("Sample Product Description");
        sampleProduct.setPrice(10.0);
        productService.saveProduct(sampleProduct);

        sampleProduct = new Product();
        sampleProduct.setName("Sample Product2");
        sampleProduct.setDescription("Sample Product2 Description");
        sampleProduct.setPrice(20.0);
        productService.saveProduct(sampleProduct);
    }

    @Test
    void saveProductTest() {
        Product newProduct = new Product();
        newProduct.setName("New Product");
        newProduct.setPrice(20.0);

        Product savedProduct = productService.saveProduct(newProduct);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getName()).isEqualTo("New Product");
    }

    @Test
    void getProductByIdTest() {
        Product product = productService.getProductById(sampleProduct.getId());
        assertThat(product).isNotNull();
        assertThat(product.getName()).isEqualTo("Sample Product2");
    }

    @Test
    void listAllProductsTest() {
        Iterable<Product> products = productService.listAllProducts();
        assertThat(products).hasSize(2);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }
}