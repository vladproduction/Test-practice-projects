package com.vladproduction.migrationjunit4junit5.exceptions;

public class IngredientByIdNotFoundException extends RuntimeException{

    public IngredientByIdNotFoundException(String message) {
        super(message);
    }
}
