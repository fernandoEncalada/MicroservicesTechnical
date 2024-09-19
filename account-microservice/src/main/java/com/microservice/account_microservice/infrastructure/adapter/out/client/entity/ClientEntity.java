package com.microservice.account_microservice.infrastructure.adapter.out.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity extends PersonEntity {

    private String contrasenia;
    private Boolean estado;

    public ClientEntity(ClientEntity client) {
        super(
                client.getNombres(),
                client.getDireccion(),
                client.getTelefono()
        );
        this.contrasenia = client.getContrasenia();
        this.estado = client.getEstado();
    }
}
