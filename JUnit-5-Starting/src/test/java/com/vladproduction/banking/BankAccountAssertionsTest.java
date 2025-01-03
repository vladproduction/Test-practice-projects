package com.vladproduction.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccountAssertions")
class BankAccountAssertionsTest {

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

    @Test
    @DisplayName("Withdraw will become negative")
    public void withdrawNotStuckAtZeroTest(){
        bankAccount.withdraw(700);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Testing activation account after creation")
    public void activeAccountTest(){
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test setter for holder name")
    public void setHolderNameTest(){
        bankAccount.setHolderName("John");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("No available to withdraw below minimum balance")
    public void noWithdrawBelowMinimumTest(){
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(3000));
    }

    @Test
    @DisplayName("Test withdraw and deposit no exceptions")
    public void noExceptionForWithdrawAndDepositTest(){
        assertAll(()->bankAccount.deposit(1000), ()->bankAccount.withdraw(500));
    }

    @Test
    @DisplayName("Test deposit timout taken for operation") //will fail if it takes longer than defined in duration
    public void depositTimeoutTest(){
        assertTimeout(Duration.ofNanos(1), ()->bankAccount.deposit(100));
    }
}