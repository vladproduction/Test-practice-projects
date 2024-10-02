package com.vladproduction.springboottestinglayersh2.repository;

import com.vladproduction.springboottestinglayersh2.RepositoryTests;
import com.vladproduction.springboottestinglayersh2.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for {@link ProductRepository}.
 * <p>
 * This class contains tests for verifying the functionality of the ProductRepository
 * in a Spring Boot application. It uses JUnit 5 for testing and Spring's testing
 * support for integration testing with an embedded database.
 * </p>
 *
 * <p>
 * It performs the following operations:
 * <ul>
 *     <li>Before each test, the database is cleaned, and two products are
 *     created and saved for use in the tests.</li>
 *     <li>The method {@code testCountProductInDB} verifies that two products
 *     are present in the database after setup.</li>
 *     <li>The method {@code testUpdateDescription} tests the ability to update
 *     a product's description and verifies that the change persists in the database.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Since this class uses JUnit 5, the {@code @RunWith(SpringRunner.class)}
 * annotation is not required, as JUnit 5 does not require a specific runner
 * to be defined for Spring tests.
 * </p>
 *
 * <p>
 * Annotations used:
 * <ul>
 *     <li>{@link SpringBootTest} - Indicates that this class is a Spring Boot test.</li>
 *     <li>{@link BeforeEach} - Indicates the method annotated should be executed before each test method.</li>
 *     <li>{@link Test} - Marks a method as a test method.</li>
 * </ul>
 * </p>
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest3 implements RepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp(){
        //clean state before
        productRepository.deleteAll();

        //create content (save products):
        Product product = new Product();
        product.setName("Prod-1");
        product.setDescription("Desc-1");
        product.setPrice(1000.0);

        Product product2 = new Product();
        product2.setName("Prod-2");
        product2.setDescription("Desc-2");
        product2.setPrice(2000.0);

        productRepository.saveAll(List.of(product, product2));
    }

    @Test
    public void testCountProductInDB(){
        long countProduct = productRepository.count();
        assertEquals(2, countProduct);
        Iterable<Product> products = productRepository.findAll();
        int count = 0;
        for(Product p : products){
            System.out.println(p);
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void testUpdateDescription(){
        Product product = new Product();
        product.setName("Prod-5");
        product.setDescription("Desc-4");
        product.setPrice(5000.0);
        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);

        //update description and save
        assert fetchedProduct != null;
        fetchedProduct.setDescription("Desc-5 (updated)");
        productRepository.save(fetchedProduct);

        //get from DB, should be updated
        Product updatedProduct = productRepository.findById(fetchedProduct.getId()).orElse(null);
        assert updatedProduct != null;
        assertEquals(fetchedProduct.getDescription(), updatedProduct.getDescription());
    }

    @Test
    public void testFetchFromDB(){
        //fetch from DB
        Product product = new Product();
        product.setName("Prod-4");
        product.setDescription("Desc-4");
        product.setPrice(4000.0);
        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);
        assertNotNull(fetchedProduct);
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());
        assertEquals(product.getPrice(), fetchedProduct.getPrice());
    }

    @Test
    public void testCreateProduct(){
        //save product, verify has ID value after save
        Product product = new Product();
        product.setName("Prod-3");
        product.setDescription("Desc-3");
        product.setPrice(3000.0);
        assertNull(product.getId()); //null before saving
        productRepository.save(product);
        assertNotNull(product.getId()); //id is existing
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }
}
