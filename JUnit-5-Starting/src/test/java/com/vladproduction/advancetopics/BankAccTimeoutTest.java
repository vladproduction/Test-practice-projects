package com.vladproduction.advancetopics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

//for all tests in class
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccParameterResolver.class)
public class BankAccTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAcc bankAcc){
        try{
            //Thread.sleep(1000); //InterruptedException: sleep interrupted
            Thread.sleep(200); //test pass
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAcc.deposit(300);
        assertEquals(300, bankAcc.getBalance());
    }

    @Test

    public void testDepositTimeoutAnnotation(BankAcc bankAcc){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAcc.deposit(300);
        assertTimeout(Duration.ofMillis(500), ()->{
            //Thread.sleep(1000);//AssertionFailedError: execution exceeded timeout of 500 ms by 514 ms
            Thread.sleep(10);//test pass
        });
    }

}
