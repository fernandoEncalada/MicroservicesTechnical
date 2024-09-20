package com.microservice.client_microservice.infrastructure.adapter.in.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.client_microservice.application.ports.in.IClientService;
import com.microservice.client_microservice.domain.model.enums.AccountType;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in.ClientRequestDto;
import com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.out.ClientResponseDto;
import com.microservice.client_microservice.infrastructure.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    IClientService clienteService;

    @InjectMocks
    ClientController controller;

    @Spy
    GlobalExceptionHandler globalExceptionHandler;

    MockMvc mockMvc;

    ObjectMapper objectMapper;

    ClientRequestDto clientRequestDto;

    ClientResponseDto clientResponseDto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        clientRequestDto = new ClientRequestDto(
                "Juan Perez", "Masculino", 30, "123456789", "Calle 123",
                "555-1234", "password", true, AccountType.AHORRO, 500.0
        );
        clientResponseDto = new ClientResponseDto(1L, 500.0, AccountType.AHORRO);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(globalExceptionHandler).build();
    }

    @Test
    void createClientTest() throws Exception {
        doReturn(clientResponseDto).when(clienteService).create(any());

        mockMvc.perform(post("/api/v1/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(clientRequestDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void getClientTest() throws Exception {
        doReturn(clientResponseDto).when(clienteService).getClient(any());

        mockMvc.perform(get("/api/v1/clientes/{id}", 1L))
                .andExpect(status().isOk());
    }
}
