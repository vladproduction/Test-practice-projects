package com.vladproduction.junit5springbootpizzadb.exceptions;

public class PizzaByIdNotFoundException extends RuntimeException{

    public PizzaByIdNotFoundException(String message) {
        super(message);
    }
}
