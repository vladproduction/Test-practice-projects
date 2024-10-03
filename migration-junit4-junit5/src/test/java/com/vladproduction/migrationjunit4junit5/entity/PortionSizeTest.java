package com.vladproduction.migrationjunit4junit5.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PortionSizeTest {

    String setUpDefaultValue;

    @Before
    public void setUp(){
        setUpDefaultValue = "Default setUp value here!";
    }

    @After
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

    @Test(expected = IllegalArgumentException.class)
    public void valueOf_invalidValue() {
        // Verify that an exception is thrown for invalid enum value
        PortionSize.valueOf("INVALID"); // This should throw an IllegalArgumentException
    }
}