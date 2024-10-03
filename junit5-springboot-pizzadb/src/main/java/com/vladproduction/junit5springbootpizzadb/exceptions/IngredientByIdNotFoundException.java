package com.vladproduction.junit5springbootpizzadb.exceptions;

public class IngredientByIdNotFoundException extends RuntimeException{

    public IngredientByIdNotFoundException(String message) {
        super(message);
    }
}
