package com.microservice.client_microservice.infrastructure.adapter.in.rest.controller;

import com.microservice.client_microservice.application.ports.in.IClientService;
import com.microservice.client_microservice.application.service.ClienteService;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clienteService;

    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientRequestDto client) {
        ClientResponseDto nuevoCliente = clienteService.create(client);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClient(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllClientes() {
        return ResponseEntity.ok(clienteService.getClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody ClientRequestDto cliente) {
        ClientResponseDto clienteActualizado = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
