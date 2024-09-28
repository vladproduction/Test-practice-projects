package com.vladproduction.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void testIndex() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view returned");
        assertEquals("index", indexController.index(), ()-> "Wrong view returned also here");
    }

    @Test
    void testOpsHandler() {
        assertTrue("not_implemented".equals(indexController.opsHandler()), ()-> "Some expensive build");
    }
}