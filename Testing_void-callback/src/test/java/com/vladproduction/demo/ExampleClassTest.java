package com.vladproduction.demo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class ExampleClassTest {

    @Test
    public void voidMethodTest() {
        ExampleClass exampleMock = mock(ExampleClass.class);
        doNothing().when(exampleMock).voidMethod();

        // Call the void method
        exampleMock.voidMethod();

        // Verify that the method was called
        verify(exampleMock).voidMethod();
    }

}