package com.vladproduction.dockertestcontainerdemo.controller;

import com.vladproduction.dockertestcontainerdemo.repository.CarRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>(
            DockerImageName.parse(
                    "mysql:8.3.0"
            )
    );

    @DynamicPropertySource
    static void configProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.jpa.generate-ddl", () -> true);

    }

    @Test
    @SneakyThrows
    void saveCars() {
        mockMvc.perform(get("http://localhost:8080/api/docker-test-container-demo/saveAllCars"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @SneakyThrows
    void getSavedCars() {
        var result = mockMvc.perform(get("http://localhost:8080/api/docker-test-container-demo/getSavedCars"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        var cars = carRepository.findAll();
        assertThat(cars).isNotNull();

        assertThat(result.getResponse().getContentAsString())
                .isEqualTo(new ObjectMapper().writeValueAsString(cars));
    }
}




















