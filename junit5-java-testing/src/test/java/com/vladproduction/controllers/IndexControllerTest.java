package com.vladproduction.controllers;

import com.vladproduction.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    public void setUp() {
        indexController = new IndexController();
    }

    //@DisplayName("Test Name:  index view as returned")
    @Test
    public void testIndex() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
        assertEquals("index", indexController.index(), ()-> "Wrong view returned also here");
    }

    @Test
    //@DisplayName("Test exception")
    public void testOpsHandler() {
        assertTrue("not_implemented".equals(indexController.opsHandler()), ()-> "Some expensive build");
    }

    @Test
    public void testOpsHandlerByException(){
        assertThrows(ValueNotFoundException.class, ()->
        {
            indexController.opsHandlerByException();
        });
    }


    @Disabled("Demo example for assertTimeout")
    @Test
    public void testTimeOut(){
        assertTimeout(Duration.ofMillis(100), ()->
        {
            Thread.sleep(5000);
            System.out.println("I got here");
        });
    }

    @Disabled("Demo example for assertTimeoutPreemptively")
    @Test
    public void testTimeoutPreemptively(){
        assertTimeoutPreemptively(Duration.ofMillis(100), ()->
        {
            Thread.sleep(5000);
            System.out.println("I got here TimeoutPreemptively");
        });
    }

    @Test
    public void testTimeOutPassed(){
        assertTimeout(Duration.ofMillis(1000), ()->
        {
            Thread.sleep(800);
            System.out.println("I got here testTimeOutPassed");
        });
    }

    @Disabled("Demo example for assumeTrue")
    @Test
    public void testAssumptionTrue() {
        assumeTrue("VPRO".equalsIgnoreCase(System.getenv("VPRO_RUNTIME"))); //no such environment, so it`s not true (test fail)
    }

    @Test
    public void testAssumptionTrueOfTwoStrings() {
        assumeTrue("VPRO".equalsIgnoreCase("VPRO"));
    }
}