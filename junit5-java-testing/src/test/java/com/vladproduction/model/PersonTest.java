package com.vladproduction.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testGroupedAssertions() {
        //given
        Person person = new Person(1L, "John", "Doe");

        //for assertEquals: 'expected', 'actual'
        //when
        assertAll("Test properties Set",
                ()->assertEquals("John", person.getFirstName()),
                ()->assertEquals("Doe", person.getLastName()));
    }

    @Test
    void testGroupedAssertionsMessaging() {
        //given
        Person person = new Person(1L, "John", "Doe");

        //when
        assertAll("Test properties Set and messaging",
                ()->assertEquals("John", person.getFirstName(), "First Name is not correct"),
                ()->assertEquals("Doe", person.getLastName(), "Last Name is not correct"));
    }
}