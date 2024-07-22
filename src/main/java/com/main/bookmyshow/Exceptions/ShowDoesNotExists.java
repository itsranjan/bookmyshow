package com.main.bookmyshow.Exceptions;

public class ShowDoesNotExists extends RuntimeException{

    public ShowDoesNotExists() {
        super("Show does not exists");
    }
}
