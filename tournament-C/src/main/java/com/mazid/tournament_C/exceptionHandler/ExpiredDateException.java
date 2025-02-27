package com.mazid.tournament_C.exceptionHandler;

public class ExpiredDateException extends RuntimeException {
    public ExpiredDateException(String message) {
        super(message);
    }
}
