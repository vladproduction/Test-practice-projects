package com.vladproduction.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    public void testDependentAssertions(){
        Owner owner = new Owner(1L, "John", "Doe");
        owner.setCity("Canvas");
        owner.setTelephone("123-123");

        assertAll("Properties test",
                ()-> assertAll("Person properties test",
                        ()->assertEquals(owner.getFirstName(), "John"),
                        ()->assertEquals(owner.getLastName(), "Doe")),
                ()-> assertAll("Owner properties test",
                        ()->assertEquals(owner.getCity(), "Canvas"),
                        ()->assertEquals(owner.getTelephone(), "123-123")));
    }

    //also available messaging to help to figure out the exception point
    @Test
    public void testDependentAssertionsMsg(){
        Owner owner = new Owner(1L, "John", "Doe");
        owner.setCity("Canvas");
        owner.setTelephone("123-123");

        assertAll("Properties test",
                ()-> assertAll("Person properties test",
                        ()->assertEquals(owner.getFirstName(), "John", "First name is not correct"),
                        ()->assertEquals(owner.getLastName(), "Doe", "Last name is not correct")),
                ()-> assertAll("Owner properties test",
                        ()->assertEquals(owner.getCity(), "Canvas", "City is not correct"),
                        ()->assertEquals(owner.getTelephone(), "123-123", "Telephone is not correct")));
    }


}