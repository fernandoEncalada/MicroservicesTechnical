package com.microservice.client_microservice.domain.model;

import com.microservice.client_microservice.infrastructure.adapter.out.client.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona {

    private String contrasenia;
    private Boolean estado;

    public Cliente(ClientEntity client) {
        super(
                client.getNombre(),
                client.getGenero(),
                client.getEdad(),
                client.getIdentificacion(),
                client.getDireccion(),
                client.getTelefono()
        );
        this.contrasenia = client.getContrasenia();
        this.estado = client.getEstado();
    }
}
