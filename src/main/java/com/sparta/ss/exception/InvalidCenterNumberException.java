package com.sparta.ss.exception;

public class InvalidCenterNumberException extends Exception{
    public String invalidCenterNumberException(){
        return "Number of centers to be generated in every two months is wrong ! Please try again";
    }
}
