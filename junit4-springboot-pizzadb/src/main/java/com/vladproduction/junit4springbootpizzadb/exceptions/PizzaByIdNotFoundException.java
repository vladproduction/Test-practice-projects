package com.vladproduction.junit4springbootpizzadb.exceptions;

public class PizzaByIdNotFoundException extends RuntimeException{

    public PizzaByIdNotFoundException(String message) {
        super(message);
    }
}
