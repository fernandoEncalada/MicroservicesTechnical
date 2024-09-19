package com.microservice.client_microservice.application.service;

import com.microservice.client_microservice.application.ports.in.IClientService;
import com.microservice.client_microservice.application.ports.out.IClientPort;
import com.microservice.client_microservice.domain.model.Cliente;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClientService {

    private final IClientPort clientPort;

    @Override
    public ClientResponseDto create(ClientRequestDto client) {
        return clientPort.create(client);
    }

    @Override
    public ClientResponseDto update(Long id, ClientRequestDto cliente) {
        return clientPort.update(id, cliente);
    }

    @Override
    public void delete(Long id) {
        clientPort.delete(id);
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        return clientPort.getClient(id);
    }

    @Override
    public List<ClientResponseDto> getClients() {
        return clientPort.getClients();
    }
}
