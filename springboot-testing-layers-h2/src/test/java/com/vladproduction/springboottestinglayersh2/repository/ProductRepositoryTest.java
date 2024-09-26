package com.vladproduction.springboottestinglayersh2.repository;

import com.vladproduction.springboottestinglayersh2.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests for the ProductRepository class.
 *
 * This class uses the @DataJpaTest annotation to configure
 * an embedded database for repository testing.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() {
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
    public void testCreateProduct() {
        //save product, verify has ID value after save
        Product product = new Product();
        product.setName("Prod-3");
        product.setDescription("Desc-3");
        product.setPrice(3000.0);
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
    }

    @Test
    public void testFetchFromDB() {
        //fetch from DB
        Product product = new Product();
        product.setName("Prod-4");
        product.setDescription("Desc-4");
        product.setPrice(4000.0);
        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);
        //should not be null
        assertNotNull(fetchedProduct);
        //should equal
        assertEquals(product.getId(), fetchedProduct.getId());
        assertEquals(product.getDescription(), fetchedProduct.getDescription());
    }

    @Test
    public void testUpdateDescription() {
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
    public void testCountProductsInDB() {
        long productCount = productRepository.count();
        assertEquals(productCount, 2);

        //get all products, list should only have two
        Iterable<Product> products = productRepository.findAll();
        int count = 0;
        for(Product p : products){
            count++;
        }
        assertEquals(count, 2);
    }

    @After
    public void tearDown() {
        productRepository.deleteAll();
    }

}