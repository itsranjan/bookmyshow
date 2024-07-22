package com.main.bookmyshow.Exceptions;

public class ScreenAlreadyAdded extends RuntimeException {
    public ScreenAlreadyAdded(){
        super("Screen Already Added");
    }
}
