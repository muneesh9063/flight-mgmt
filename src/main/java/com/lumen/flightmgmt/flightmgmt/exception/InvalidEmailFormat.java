package com.lumen.flightmgmt.flightmgmt.exception;

public class InvalidEmailFormat extends RuntimeException{
    public InvalidEmailFormat(String message){
        super(message);
    }
}
