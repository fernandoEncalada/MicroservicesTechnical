package com.microservice.client_microservice.application.service;

import com.microservice.client_microservice.application.ports.out.IClientPort;
import com.microservice.client_microservice.domain.model.enums.AccountType;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @Mock
    IClientPort clientPort;

    @InjectMocks
    ClienteService clienteService;

    ClientRequestDto requestDto;

    ClientResponseDto responseDto;

    @BeforeEach
    void setUp() {
        requestDto = new ClientRequestDto("", "Femenino", 20, "1",
                "Cayambe", "0964063537", "1111", true,
                AccountType.CORRIENTE, 100.0);
        responseDto = new ClientResponseDto(1L, 100.0, AccountType.CORRIENTE);
    }

    @Test
    void createClientTest() {
        doReturn(responseDto).when(clientPort).create(any());

        ClientResponseDto response = clienteService.create(requestDto);

        assertNotNull(response);
    }

    @Test
    void getClientTest() {
        doReturn(responseDto).when(clientPort).getClient(any());

        ClientResponseDto response = clienteService.create(requestDto);

        assertNotNull(response);
    }
}
