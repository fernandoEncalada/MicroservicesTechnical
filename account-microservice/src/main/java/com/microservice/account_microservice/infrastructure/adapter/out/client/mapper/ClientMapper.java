package com.microservice.account_microservice.infrastructure.adapter.out.client.mapper;

import com.microservice.account_microservice.domain.model.cliente.Cliente;
import com.microservice.account_microservice.infrastructure.adapter.out.client.entity.ClientEntity;

public class ClientMapper {

//    public static Account toDomain(AccountResponseDto responseDto) {
//        return new Account(
//                responseDto.get
//        );
//    }

    public static Cliente toDomain(ClientEntity clientEntity) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clientEntity.getNombres());
        cliente.setDireccion(clientEntity.getDireccion());
        cliente.setTelefono(clientEntity.getTelefono());
        cliente.setEstado(clientEntity.getEstado());
        cliente.setContrasenia(clientEntity.getContrasenia());
        return cliente;
    }
}
