package com.microservice.client_microservice.infrastructure.adapter.out.client.mapper;

import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import com.microservice.client_microservice.infrastructure.adapter.out.client.entity.ClientEntity;

public class ClientMapper {
    public static ClientResponseDto toResponseDto(ClientEntity clientEntity) {
        return new ClientResponseDto(clientEntity.getNombre(), clientEntity.getDireccion(), clientEntity.getTelefono(),
                clientEntity.getContrasenia(), clientEntity.getEstado());
    }

    public static ClientEntity toEntity(ClientRequestDto client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setNombre(client.getNombre());
        clientEntity.setIdentificacion(client.getIdentificacion());
        clientEntity.setDireccion(client.getDireccion());
        clientEntity.setGenero(client.getGenero());
        clientEntity.setTelefono(client.getTelefono());
        clientEntity.setEdad(client.getEdad());
        clientEntity.setContrasenia(client.getContrasenia());
        clientEntity.setEstado(client.getEstado());

        return clientEntity;
    }
}
