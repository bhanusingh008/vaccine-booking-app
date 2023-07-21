package com.bhxnusingh.vaccinebookingsystem.exception;

public class DoseAlreadyTaken extends RuntimeException{
    public DoseAlreadyTaken(String message){
        super(message);
    }
}
