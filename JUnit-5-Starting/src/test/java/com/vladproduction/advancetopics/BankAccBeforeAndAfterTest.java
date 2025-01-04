package com.vladproduction.advancetopics;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //init and endMethods could be used without 'static'
public class BankAccBeforeAndAfterTest {
    private static final Logger log = Logger.getLogger("logger: ");
    private static BankAcc bankAccount;

    @BeforeAll
    public void init(){
        log.info("Hello!");
    }

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAcc(1000, 0);
    }

    @Test
    public void testWithdraw() {
        log.info("withdraw");
        bankAccount.withdraw(300);
        assertEquals(700, bankAccount.getBalance());
    }

    @Test
    public void testDeposit() {
        log.info("deposit");
        bankAccount.deposit(500);
        assertEquals(1500, bankAccount.getBalance());
    }

    @AfterEach
    public void clearUp(){
        log.info("---");
    }

    @AfterAll
    public void endMethods(){
        log.info("By!");
    }

}
