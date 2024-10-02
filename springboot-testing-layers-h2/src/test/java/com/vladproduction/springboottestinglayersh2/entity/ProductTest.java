package com.vladproduction.springboottestinglayersh2.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void testGettersAndSetters() {
        Product product = new Product();

        product.setId(1L);
        product.setName("Sample Product");
        product.setDescription("This is a sample product.");
        product.setPrice(19.99);

        assertEquals(1L, product.getId());
        assertEquals("Sample Product", product.getName());
        assertEquals("This is a sample product.", product.getDescription());
        assertEquals(19.99, product.getPrice());
    }

    @Test
    public void testGroupedAssertionsForProduct() {
        //given
        Product product = new Product();
        product.setName("Base Product");
        product.setDescription("Base Product Description");
        product.setPrice(10000.0);

        //for assertEquals: 'expected', 'actual'
        //when
        assertAll("Test properties Set",
                ()->assertEquals("Base Product", product.getName()),
                ()->assertEquals("Base Product Description", product.getDescription()),
                ()->assertEquals(10000.0, product.getPrice()));
    }

    @Test
    public void testToString() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Sample Product");
        product.setDescription("This is a sample product.");
        product.setPrice(19.99);

        String expectedOutput = "Product{id=1, name='Sample Product', description='This is a sample product.', price=19.99}";
        assertEquals(expectedOutput, product.toString());
    }

}