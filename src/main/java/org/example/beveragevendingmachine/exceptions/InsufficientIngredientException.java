package org.example.beveragevendingmachine.exceptions;

public class InsufficientIngredientException extends Exception{
    public InsufficientIngredientException(String message){
        super(message);
    }
}
