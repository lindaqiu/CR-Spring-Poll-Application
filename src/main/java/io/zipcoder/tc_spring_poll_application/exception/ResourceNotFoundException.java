package io.zipcoder.tc_spring_poll_application.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//This informs Spring that any request mapping that throws a ResourceNotFoundException should result in a
//404 NOT FOUND http status.

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

/*
Create a ResourceNotFoundException class that extends RuntimeException.
We'll use this to signal when a requested resource is not found.
Annotate the ResourceNotFoundException class with @ResponseStatus(HttpStatus.NOT_FOUND).

Implement three constructors
A no-arg constructor
A constructor that takes a String message and passes it to the superclass constructor
A constructor that takes String message and Throwable cause and passes both to the superclass constructor
 */