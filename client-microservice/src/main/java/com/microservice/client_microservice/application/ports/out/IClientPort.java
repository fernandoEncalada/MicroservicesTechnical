package com.microservice.client_microservice.application.ports.out;

import com.microservice.client_microservice.domain.model.Cliente;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;

import java.util.List;

public interface IClientPort {

    ClientResponseDto create(ClientRequestDto client);

    ClientResponseDto update(Long id, ClientRequestDto cliente);
    void delete(Long id);

    ClientResponseDto getClient(Long id);

    List<ClientResponseDto> getClients();
}
