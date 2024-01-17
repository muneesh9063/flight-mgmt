package com.lumen.flightmgmt.flightmgmt.exception;

public class InvalidPhoneNumberFormat extends RuntimeException{
    public InvalidPhoneNumberFormat(String message){
        super(message);
    }
}
