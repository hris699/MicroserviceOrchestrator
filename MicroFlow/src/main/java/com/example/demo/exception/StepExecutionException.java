package com.example.demo.exception;

public class StepExecutionException extends RuntimeException {
    public StepExecutionException(String message) {
        super(message);
    }
}