package com.main.bookmyshow.Exceptions;

public class UserAlreadyExistsWithEmail extends RuntimeException {
    public UserAlreadyExistsWithEmail() {
        super("User Already Exists with this EmailId");
    }
}
