package com.vladproduction.services.springdatajpa;

import com.vladproduction.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Disabled(value = "Disable until start Mocking")
class OwnerSDJpaServiceTest {

    OwnerSDJpaService service;

    @BeforeEach
    public void setUpTest() {
        service = new OwnerSDJpaService(null, null, null);
    }

    @Disabled
    @Test
    public void findByLastNameTest() {
        Owner ownerFound = service.findByLastName("Doe");
    }

    @Test
    public void findAllByLastNameLikeTest() {
    }

    @Test
    public void findAllTest() {
    }

    @Test
    public void findByIdTest() {
    }

    @Test
    public void saveTest() {
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void deleteByIdTest() {
    }
}