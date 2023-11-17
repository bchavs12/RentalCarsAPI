package com.example.RentalCars.exception;

//This exception typically indicates that a requested resource could not be found.
// In the context of a web application or API, it might be thrown when a client requests a resource
// (like a specific record in a database), but that resource does not exist.
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
