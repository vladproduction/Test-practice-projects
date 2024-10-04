package com.vladproduction.mocksannotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class SpyExampleTest {
    @Spy
    Calculator calculatorSpy = new Calculator();
    @InjectMocks
    Calculator calculator;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSpy() {
        assertEquals(2, calculatorSpy.subtraction(5, 3));
        doReturn(10).when(calculatorSpy).addition(5, 5); // Change behavior

        assertEquals(10, calculatorSpy.addition(5, 5)); // This will now return 10
    }

    static class Calculator{
        public int addition(int a, int b) {
            return a + b;
        }
        public int subtraction(int a, int b) {
            return a - b;
        }
    }

}
