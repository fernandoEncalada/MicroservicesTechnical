package com.microservice.account_microservice.domain.model.enums;

public enum AccountType {

    AHORRO("Ahorro"),
    CORRIENTE("Corriente");

    private final String description;

    // Constructor
    AccountType(String description) {
        this.description = description;
    }

    // Getter para obtener la descripción
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
