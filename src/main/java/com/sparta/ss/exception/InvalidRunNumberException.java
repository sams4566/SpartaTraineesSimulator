package com.sparta.ss.exception;

public class InvalidRunNumberException extends Exception{
    @Override
    public String getMessage() {
        return "Number of runs is wrong ! Please try again";
    }
}
