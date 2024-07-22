package com.main.bookmyshow.Exceptions;

public class ShowAlreadyPresentAtTheGivenTime extends RuntimeException{
    public ShowAlreadyPresentAtTheGivenTime(){
        super("Show Already Present At The Given Time");
    }
}
