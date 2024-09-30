package com.vladproduction.model;

import com.vladproduction.ModelsTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

//@Tag("model")
public class OwnerTest implements ModelsTest {

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

    @Test
    public void testDependentAssertions_assertThat_Hamcrest(){
        Owner owner = new Owner(1L, "John", "Doe");
        owner.setCity("Canvas");
        owner.setTelephone("123-123");

        //after added dependency hamcrest-library:
        assertThat(owner.getCity(), is("Canvas"));
    }


}