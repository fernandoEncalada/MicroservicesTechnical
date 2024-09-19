package com.microservice.client_microservice.infrastructure.exception;

public class ClientException extends RuntimeException{
    public ClientException(String message) {
        super(message);
    }
}
