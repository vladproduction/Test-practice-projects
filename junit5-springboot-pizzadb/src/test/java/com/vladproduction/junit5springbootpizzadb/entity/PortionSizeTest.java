package com.vladproduction.junit5springbootpizzadb.entity;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PortionSizeTest {

    String setUpDefaultValue;

    @BeforeEach
    public void setUp(){
        setUpDefaultValue = "Default setUp value here!";
    }

    @AfterEach
    public void tearDown(){
        setUpDefaultValue = null;
    }

    @Test
    public void values() {
        // Get the array of enum constants
        PortionSize[] expectedSizes = {PortionSize.SMALL, PortionSize.MEDIUM, PortionSize.HUGE};

        // Retrieve the values from the enum
        PortionSize[] actualSizes = PortionSize.values();

        // Verify that the expected and actual arrays are the same
        assertArrayEquals(expectedSizes, actualSizes);
    }

    @Test
    public void valueOf() {
        // Verify that valueOf returns the correct enum constant
        assertEquals(PortionSize.SMALL, PortionSize.valueOf("SMALL"));
        assertEquals(PortionSize.MEDIUM, PortionSize.valueOf("MEDIUM"));
        assertEquals(PortionSize.HUGE, PortionSize.valueOf("HUGE"));
    }

    @Test
    public void valueOf_invalidValue() {
        // Verify that an exception is thrown for invalid enum value
        assertThrows(IllegalArgumentException.class, () -> {
            PortionSize.valueOf("INVALID"); // This should throw an IllegalArgumentException
        });
    }
}