package com.Hospital_Management_System.exceptions;

public class InsuranceException extends RuntimeException{
    public InsuranceException(String message){
        super(message);
    }
    public InsuranceException(String message, Throwable cause) {
        super(message, cause);
    }
}
