package com.FamilyApp.exception;

public class InvalidInputException extends Exception{
    public InvalidInputException() {
        super("Enter correct number of adults, children or infants.");
    }
}
