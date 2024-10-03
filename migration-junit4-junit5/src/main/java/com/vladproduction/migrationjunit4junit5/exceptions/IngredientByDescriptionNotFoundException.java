package com.vladproduction.migrationjunit4junit5.exceptions;

public class IngredientByDescriptionNotFoundException extends RuntimeException{

    public IngredientByDescriptionNotFoundException(String message) {
        super(message);
    }
}
