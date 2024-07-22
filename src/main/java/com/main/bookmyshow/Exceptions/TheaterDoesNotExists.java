package com.main.bookmyshow.Exceptions;

public class TheaterDoesNotExists extends RuntimeException{
    public TheaterDoesNotExists() {
        super("Theater does not Exists");
    }
}
