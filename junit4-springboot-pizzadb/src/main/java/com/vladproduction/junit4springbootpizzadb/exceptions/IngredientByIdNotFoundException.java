package com.vladproduction.junit4springbootpizzadb.exceptions;

public class IngredientByIdNotFoundException extends RuntimeException{

    public IngredientByIdNotFoundException(String message) {
        super(message);
    }
}
