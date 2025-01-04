package com.vladproduction.advancetopics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(BankAccParameterResolver.class)
public class BankAccRepeatedTestTest {

    @RepeatedTest(5)
    @DisplayName("deposit(500) successfully")
    void depositTest(BankAcc bankAcc) {
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("deposit(500) successfully")
    void depositTestRepetitionInfo(BankAcc bankAcc, RepetitionInfo repetitionInfo) {
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBalance());
        System.out.println("#: " + repetitionInfo.getCurrentRepetition());
    }

}
