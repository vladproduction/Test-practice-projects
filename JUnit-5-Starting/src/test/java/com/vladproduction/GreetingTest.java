package com.vladproduction;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;


    @BeforeAll
    public static void beforeAll() {
        System.out.println("@BeforeAll - only colling Once!");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("In Before Each.....");
        greeting = new Greeting();
    }

    @Test
    public void testHelloWorld() {
        System.out.println(greeting.helloWorld());
    }

    @Test
    public void testHelloYou() {
        System.out.println(greeting.helloYou("Body"));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("In After Each.....");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll - only colling Once!");
    }
}