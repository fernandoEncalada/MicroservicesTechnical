package com.microservice.client_microservice.domain.model.enums;

public enum MovementType {
    RETIRO("Retiro"),
    DEPOSITO("Deposito");

    private final String description;

    // Constructor
    MovementType(String description) {
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
