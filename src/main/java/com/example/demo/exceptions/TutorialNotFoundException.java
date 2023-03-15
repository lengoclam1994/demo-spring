package com.example.demo.exceptions;

public class TutorialNotFoundException extends Exception{
    public TutorialNotFoundException(int id){
        super("TutorialNotFoundException with id="+id);
    }
}
