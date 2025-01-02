package com.vladproduction.demomath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberHelperMathTest {

    @Test
    void additionPositiveTest() {
        NumberHelperMath numberHelperMath = new NumberHelperMath();
        assertEquals(2, numberHelperMath.addition(1, 1));
        assertEquals(20, numberHelperMath.addition(10, 10));
        assertEquals(10, numberHelperMath.addition(9, 1));

    }

    @Test
    void additionNegativeTest() {
        NumberHelperMath numberHelperMath = new NumberHelperMath();
        assertNotEquals(2, numberHelperMath.addition(0, 1));
        assertNotEquals(2, numberHelperMath.addition(1000, 1));
        assertNotEquals(2, numberHelperMath.addition(0, -21));
    }

    @Test
    void additionForDebuggingTest() {
        NumberHelperMath numberHelperMath = new NumberHelperMath();
        assertEquals(3, numberHelperMath.additionForDebugging(1, 2));
    }
}