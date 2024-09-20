package com.microservice.account_microservice.application.service;

import com.microservice.account_microservice.application.ports.out.ICuentaPort;
import com.microservice.account_microservice.domain.model.enums.AccountType;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CuentaServiceTest {

    @Mock
    ICuentaPort cuentaPort;

    @InjectMocks
    CuentaService cuentaService;

    AccountResponseDto accountResponseDto;

    AccountRequestDto accountRequestDto;

    @BeforeEach
    void setUp(){
        accountRequestDto = new AccountRequestDto(AccountType.AHORRO, 100.0, false,
                1L);
        accountResponseDto = new AccountResponseDto("123", "AHORRO", 1000.0,
                true, "Fernando");

    }

    @Test
    void createAccountTest(){
        when(cuentaPort.create(any())).thenReturn(accountResponseDto);

        AccountResponseDto accountResponseDto1 = cuentaService.create(accountRequestDto);

        assertNotNull(accountResponseDto1);
    }

    @Test
    void getAccountTest(){
        when(cuentaPort.get(any())).thenReturn(accountResponseDto);

        AccountResponseDto accountResponseDto1 = cuentaService.get(1L);

        assertNotNull(accountResponseDto1);
    }
}
