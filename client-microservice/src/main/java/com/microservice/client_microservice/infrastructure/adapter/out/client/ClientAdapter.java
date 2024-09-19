package com.microservice.client_microservice.infrastructure.adapter.out.client;

import com.microservice.client_microservice.application.ports.out.IClientPort;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import com.microservice.client_microservice.infrastructure.adapter.out.client.entity.ClientEntity;
import com.microservice.client_microservice.infrastructure.adapter.out.client.mapper.ClientMapper;
import com.microservice.client_microservice.infrastructure.adapter.out.client.repository.ClientRepository;
import com.microservice.client_microservice.infrastructure.exception.DataNotFoundException;
import com.microservice.client_microservice.infrastructure.rabbitmq.ClienteEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientAdapter implements IClientPort {

    private final ClienteEventPublisher eventPublisher;
    private final ClientRepository clienteRepository;

    @Transactional
    @Override
    public ClientResponseDto create(ClientRequestDto client) {

        // Guardar el cliente en la base de datos
        ClientEntity clienteGuardado = clienteRepository.save(ClientMapper.toEntity(client));

        // Publicar el evento de creación de cliente
        ClientResponseDto responseDto = ClientMapper.toResponseDto(clienteGuardado);
        eventPublisher.publishClienteCreated(new ClientResponseDto(clienteGuardado.getId(), client.getSaldoInicial(), client.getTipoCuenta()));
        // Devolver el cliente creado
        return responseDto;
    }

    @Transactional
    @Override
    public ClientResponseDto update(Long id, ClientRequestDto cliente) {
        ClientEntity clientEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Cliente no encontrado con ID: " + id));

        clientEntity.setContrasenia(cliente.getContrasenia());
        clientEntity.setEstado(cliente.getEstado());
        clientEntity.setNombre(cliente.getNombre());
        clientEntity.setIdentificacion(cliente.getIdentificacion());
        clientEntity.setDireccion(cliente.getDireccion());
        clientEntity.setGenero(cliente.getGenero());
        clientEntity.setTelefono(cliente.getTelefono());
        clientEntity.setEdad(cliente.getEdad());

        return ClientMapper.toResponseDto(clienteRepository.save(clientEntity));
    }


    @Override
    @Transactional
    public void delete(Long id) {
        Optional<ClientEntity> clienteEntityOptional = clienteRepository.findById(id);

        if (clienteEntityOptional.isEmpty()) {
            throw new DataNotFoundException("Cliente no encontrado con ID: " + id);
        }

        ClientEntity clientEntity = clienteEntityOptional.get();
        clientEntity.setEstado(false);

        clienteRepository.save(clientEntity);
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        Optional<ClientEntity> clienteEntityOptional = clienteRepository.findById(id);

        if (clienteEntityOptional.isEmpty()) {
            throw new DataNotFoundException("Cliente no encontrado con ID: " + id);
        }

        return ClientMapper.toResponseDto(clienteEntityOptional.get());
    }


    @Override
    public List<ClientResponseDto> getClients() {
        List<ClientEntity> clientEntities = clienteRepository.findAll();

        return clientEntities.stream()
                .map(ClientMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
