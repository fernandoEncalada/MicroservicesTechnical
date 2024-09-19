package com.microservice.account_microservice.infrastructure.adapter.in.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.account_microservice.application.ports.in.ICuentaService;
import com.microservice.account_microservice.domain.model.enums.AccountType;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.exception.GlobalExceptionHandler;
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
public class AccountControllerTest {
    @Mock
    ICuentaService accountService;

    @InjectMocks
    AccountController controller;

    AccountResponseDto accountResponseDto;

    AccountRequestDto accountRequestDto;

    @Spy
    GlobalExceptionHandler globalExceptionHandler;
    MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        accountRequestDto = new AccountRequestDto("", AccountType.AHORRO, 100.0, false,
                1L);
        accountResponseDto = new AccountResponseDto("123", "AHORRO", 1000.0,
                true, "Fernando");
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(globalExceptionHandler).build();
    }

    @Test
    void createAccountTest() throws Exception {
        doReturn(accountResponseDto).when(accountService).create(any());

        mockMvc.perform(post("/api/v1/cuentas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(accountRequestDto)))
                .andExpect(status().isCreated());
    }


    @Test
    void getAccountTest() throws Exception {
        doReturn(accountResponseDto).when(accountService).get(any());

        mockMvc.perform(get("/api/v1/cuentas/{id}", 1L))
                .andExpect(status().isOk());
    }

}
