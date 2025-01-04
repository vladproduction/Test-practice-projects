package com.vladproduction.advancetopics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT) //to have execution of tests in parallel mode
@ExtendWith(BankAccParameterResolver.class)
public class BankAccExecutionParallelTest {

    @Test
    @DisplayName("deposit(500) successfully: 1 sec")
    void depositTest1(BankAcc bankAcc) {
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBalance());
    }

    @Test
    @DisplayName("deposit(1000) successfully: 4 sec")
    void depositTest2(BankAcc bankAcc) {
        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAcc.deposit(1000);
        assertEquals(1000, bankAcc.getBalance());
    }

    @Test
    @DisplayName("deposit(1500) successfully: 2 sec")
    void depositTest3(BankAcc bankAcc) {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAcc.deposit(1500);
        assertEquals(1500, bankAcc.getBalance());
    }

}
