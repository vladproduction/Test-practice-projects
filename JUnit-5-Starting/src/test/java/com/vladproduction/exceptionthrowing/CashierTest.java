package com.vladproduction.exceptionthrowing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashierTest {

    @Test
    public void validateCashierThrowsIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, ()->{
            Cashier.validateCashier("USD", 100);
        });
    }

    @Test
    public void validateCashierThrowsInvalidAmountExceptionTest() {
        assertThrows(InvalidAmountException.class, ()->{
            Cashier.validateCashier("GBP", -100);
        });
    }


}