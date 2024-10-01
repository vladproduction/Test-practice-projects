package com.vladproduction.springboottestinglayersh2.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladproduction.springboottestinglayersh2.entity.Product;
import com.vladproduction.springboottestinglayersh2.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BASE_URL = "/api/products";
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
    }

    @Test
    public void testGetAllProducts() throws Exception {

        Product product = new Product();
        product.setName("Sample Product");
        product.setDescription("This is a sample product.");
        product.setPrice(19.99);


        Product product1 = createProduct(product);
        Product product2 = createProduct(product);
        Product product3 = createProduct(product);

        Product getById1 = getProductById(product1.getId());
        Product getById2 = getProductById(product2.getId());
        Product getById3 = getProductById(product3.getId());

        assertNotNull(getById1);
        assertNotNull(getById2);
        assertNotNull(getById3);

        assertEquals(product1.getId(), getById1.getId());
        assertEquals(product2.getId(), getById2.getId());
        assertEquals(product3.getId(), getById3.getId());

        var result = mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        Product[] products = fromJsonAsArray(json);

        assertTrue(products.length == 3);
        assertEquals(products.length, 3);

    }

    private Product createProduct(Product product) throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders
                        .post(BASE_URL)
                        .contentType("application/json")
                        .content(toJson(product))
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        return fromJson(json);
    }

    private static String toJson(Object obj) throws JsonProcessingException {

        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    private static Product fromJson(String str) throws JsonProcessingException {

        return OBJECT_MAPPER.readValue(str, Product.class);
    }

    private static Product[] fromJsonAsArray(String str) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(str, Product[].class);
    }

    private  Product getProductById(Long id) throws Exception {

        var result = mockMvc.perform(get(BASE_URL + "/" + id)) // Assuming your endpoint is "api/products/{id}"
                .andExpect(status().isOk()).andReturn();
        String json = result.getResponse().getContentAsString();
        return fromJson(json);

    }

}