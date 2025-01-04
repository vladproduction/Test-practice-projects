package com.vladproduction.advancetopics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccParameterResolver.class)
public class BankAccDITest {

    @Test
    @DisplayName("deposit(500) successfully")
    void depositTest(BankAcc bankAcc) {
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBalance());
    }

}