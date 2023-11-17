package com.example.RentalCars.exception;

//This exception indicates that there is an issue with the data provided.
// It's often thrown when attempting to (create or update) a resource,
// and the provided data doesn't meet certain validation criteria
public class InvalidDataException extends Exception{
    public InvalidDataException(String message) {
        super(message);
    }
}
