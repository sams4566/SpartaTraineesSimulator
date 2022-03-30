package com.sparta.ss.exception;

public class InvalidChoiceOfOutput extends Exception{
    @Override
    public String getMessage() {
        return "The choice of output entered is wrong ! Please try again !";
    }
}
