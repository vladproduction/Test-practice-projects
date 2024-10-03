package com.vladproduction.junit4springbootpizzadb.exceptions;

public class IngredientByDescriptionNotFoundException extends RuntimeException{

    public IngredientByDescriptionNotFoundException(String message) {
        super(message);
    }
}
