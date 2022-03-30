package com.sparta.ss.exception;

public class InvalidCenterNumberException extends Exception{
    @Override
    public String getMessage() {
        return "Number of centers to be generated in every two months is wrong ! Please try again";
    }
}
