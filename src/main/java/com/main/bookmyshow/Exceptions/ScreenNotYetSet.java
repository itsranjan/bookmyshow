package com.main.bookmyshow.Exceptions;

public class ScreenNotYetSet extends RuntimeException {
    public ScreenNotYetSet(){
        super("Screen Not Yet Set To This Theater");
    }
}
