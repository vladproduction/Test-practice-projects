package com.vladproduction.banking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test Activation Account - testRun(assumeTrue)")
    public void testActiveAccount_assumptionRunTest(){
        BankAccount bankAccount = new BankAccount(1000, 0);
        assumeTrue(bankAccount != null); // before assertion check if object for testing is not null
        assertTrue(bankAccount.isActive());
    }

    //@Test
    @DisplayName("Test Activation Account - testAborted(assumeTrue)")
    public void testActiveAccount_assumptionAbortedTest(){
        BankAccount bankAccount = new BankAccount(1000, 0);
        assumeTrue(bankAccount == null); // before assertion check if object for testing is not null
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test Activation Account - testRun(assumeFalse)")
    public void testActiveAccount_assumptionRunTestAssumeFalse(){
        BankAccount bankAccount = new BankAccount(1000, 0);
        assumeFalse(bankAccount == null); // before assertion check if object for testing is not null
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test Activation Account - testRun(assumingThat)")
    public void testActiveAccount_assumptionRunTestAssumingThat(){
        BankAccount bankAccount = new BankAccount(1000, 0);
        assumingThat(bankAccount != null, ()-> bankAccount.setActive(true));
        assumingThat(bankAccount != null, ()-> bankAccount.deposit(5000));
        //or execution of the test if first parameter is pass
        assumingThat(bankAccount != null, ()-> assertTrue(bankAccount.isActive()));
    }

    @Test
    @DisplayName("Test Activation Account - testRun(assumingThat)")
    public void testActiveAccount_assumptionRunTestAssumingThatIsFalse(){
        BankAccount bankAccount = new BankAccount(1000, 0);
        //test run because: assertion inside the assumingThat will be skipped because the condition bankAccount == null is false;
        //in terms of outcomes, the test does not fail or pass based on the assertion;
        //it simply ends without any evaluation of assertTrue(bankAccount.isActive())
        assumingThat(bankAccount == null, ()-> assertTrue(bankAccount.isActive()));
    }



}
