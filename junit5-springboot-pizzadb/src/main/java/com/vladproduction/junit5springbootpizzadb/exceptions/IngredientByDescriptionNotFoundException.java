package com.vladproduction.junit5springbootpizzadb.exceptions;

public class IngredientByDescriptionNotFoundException extends RuntimeException{

    public IngredientByDescriptionNotFoundException(String message) {
        super(message);
    }
}
