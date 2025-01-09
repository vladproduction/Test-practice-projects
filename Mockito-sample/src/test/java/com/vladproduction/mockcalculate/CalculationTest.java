package com.vladproduction.mockcalculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculationTest {

    @Mock
    Calculation calculation;

    @BeforeEach
    public void setupMocks() {
        when(calculation.divide(6, 3)).thenReturn(2.0);
    }

    @Test
    public void divideTest() {
        assertEquals(2.0, calculation.divide(6, 3));
    }
}