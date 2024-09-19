package com.microservice.account_microservice.infrastructure.exception;

public class AccountException extends RuntimeException{
    public AccountException(String message) {
        super(message);
    }
}
