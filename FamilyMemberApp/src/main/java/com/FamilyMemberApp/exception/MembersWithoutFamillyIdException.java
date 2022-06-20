package com.FamilyMemberApp.exception;

public class MembersWithoutFamillyIdException extends Exception {
    public MembersWithoutFamillyIdException() {
        super("Input family id.");
    }
}