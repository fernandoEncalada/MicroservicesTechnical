package com.microservice.client_microservice.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {
    @Test
    public void testClienteGetterSetter() {
        Cliente cliente = new Cliente();

        cliente.setContrasenia("password123");
        cliente.setEstado(true);

        assertEquals("password123", cliente.getContrasenia());
        assertTrue(cliente.getEstado());
    }

    @Test
    public void testClienteConstructor() {
        Cliente cliente = new Cliente("password123", true);

        assertEquals("password123", cliente.getContrasenia());
        assertTrue(cliente.getEstado());
    }
}
