package com.vladproduction.banking;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderExecutionTest {

    static BankAccount bankAccount = new BankAccount(0, 0); //one object to handle

    // Deposit method
    @Test
    @Order(1)  // This test will run first
    public void testDeposit() {
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    // Withdraw method
    @Test
    @Order(2)  // This test will run second
    public void testWithdraw() {
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }
}
