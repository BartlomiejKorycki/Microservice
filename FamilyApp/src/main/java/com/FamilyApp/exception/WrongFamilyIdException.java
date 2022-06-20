package com.FamilyApp.exception;

public class WrongFamilyIdException extends Exception {
    public WrongFamilyIdException() {
        super("This family id does not exist in database.");
    }
}