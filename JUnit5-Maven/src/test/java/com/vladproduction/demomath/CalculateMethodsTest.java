package com.vladproduction.demomath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateMethodsTest {

    private CalculateMethods calculateMethods;

    @BeforeEach
    public void setUp() {
        calculateMethods = new CalculateMethods();
    }

    @Test
    public void dividePositiveTest() {
        assertEquals(10, calculateMethods.divide(100, 10));
        assertEquals(2, calculateMethods.divide(4, 2));
        assertEquals(5, calculateMethods.divide(15, 3));
    }

    @Test
    public void divideByZero(){
        assertThrows(ArithmeticException.class, ()-> calculateMethods.divide(100.0, 0.0));
    }

    @Test
    void divideIntegersPositiveTest() {
        assertEquals(10, calculateMethods.divideIntegers(100, 10));
        assertEquals(1, calculateMethods.divideIntegers(100, 100));
        assertEquals(2, calculateMethods.divideIntegers(10, 5));
    }

    @Test
    void divideIntegersNegativeTest() {
        assertNotEquals(11, calculateMethods.divideIntegers(100, 10));
        assertNotEquals(10, calculateMethods.divideIntegers(100, 100));
        assertNotEquals(15, calculateMethods.divideIntegers(10, 5));
    }

    @Test
    public void divideIntegersByZero(){
        assertThrows(ArithmeticException.class, ()-> calculateMethods.divideIntegers(100, 0));
    }
}