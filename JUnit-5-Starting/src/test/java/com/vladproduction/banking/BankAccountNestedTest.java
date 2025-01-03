package com.vladproduction.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testing BankAccount with Nested class")
public class BankAccountNestedTest {

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
    @DisplayName("withdraw: 300 successfully")
    void withdrawTest() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit: 500 successfully")
    void depositTest() {
        bankAccount = new BankAccount(400, 0);
        assertEquals(900, bankAccount.deposit(500));
    }

    @Nested
    class WhenBalanceEqualsZero{
        @Test
        @DisplayName("Withdrawing below min Balance: exception")
        public void testWithdrawMinBalanceIs_0(){
            bankAccount = new BankAccount(0,0);
            assertThrows(RuntimeException.class, ()->bankAccount.withdraw(500));

        }

        @Test
        @DisplayName("Withdrawing and getting negative balance")
        public void testWithdrawMinBalanceIsNegative_1000(){
            bankAccount = new BankAccount(0,-1000);
            bankAccount.withdraw(500);
            assertEquals(-500, bankAccount.getBalance());
        }

    }

}
