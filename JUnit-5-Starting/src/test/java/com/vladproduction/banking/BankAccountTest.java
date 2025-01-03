package com.vladproduction.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
class BankAccountTest {

    private BankAccount bankAccount;
    private double balance;
    private double minimumBalance;

    @BeforeEach
    void setUp() {
        balance = 500;
        minimumBalance = -1000;
        bankAccount = new BankAccount(balance, minimumBalance);
    }

    @Test
    void getBalanceTest() {
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void getMinimumBalanceTest() {
        assertEquals(minimumBalance, bankAccount.getMinimumBalance());
    }

    @Test
    @DisplayName("withdraw(300) successfully")
    void withdrawTest() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit(500) successfully")
    void depositTest() {
        bankAccount = new BankAccount(400, 0);
        assertEquals(900, bankAccount.deposit(500));
    }
}