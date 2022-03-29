package com.sparta.ss.exception;

public class InvalidYearException extends Exception{

    @Override
    public String getMessage() {
        return "Number of years is wrong ! Please try again";
    }
}
