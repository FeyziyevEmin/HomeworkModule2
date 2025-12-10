package org.example.lesson_17.Practice.Exception;

public class CarNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}

