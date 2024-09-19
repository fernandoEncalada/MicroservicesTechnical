package com.microservice.account_microservice.infrastructure.adapter.out.client;

import com.microservice.account_microservice.application.ports.out.IClientPort;
import com.microservice.account_microservice.domain.model.cliente.Cliente;
import com.microservice.account_microservice.infrastructure.adapter.out.client.entity.ClientEntity;
import com.microservice.account_microservice.infrastructure.adapter.out.client.mapper.ClientMapper;
import com.microservice.account_microservice.infrastructure.adapter.out.client.repository.ClientServiceFeignClient;
import com.microservice.account_microservice.infrastructure.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ClientAdapter implements IClientPort {

    private final ClientServiceFeignClient clienteRepository;

    @Override
    public Cliente getClient(Long id) {
        ResponseEntity<ClientEntity> clienteResponse = clienteRepository.getClientById(id);

        if (null == clienteResponse || !clienteResponse.getStatusCode().is2xxSuccessful())
            throw new DataNotFoundException("No se encontró al cliente con el id: " + id);

        return ClientMapper.toDomain(Objects.requireNonNull(clienteResponse.getBody()));
    }
}
