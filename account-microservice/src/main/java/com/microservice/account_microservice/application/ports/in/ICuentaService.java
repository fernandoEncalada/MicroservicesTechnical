package com.microservice.account_microservice.application.ports.in;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.StatusAccountReportDto;

import java.util.Date;
import java.util.List;

public interface ICuentaService {

    AccountResponseDto create(AccountRequestDto cuenta);

    AccountResponseDto get(Long id);
    
    List<AccountResponseDto> getAll();

    AccountResponseDto update(Long id, AccountRequestDto cuenta);
    
    void delete(Long id);

    List<AccountResponseDto> getAccountsByClientId(Long idCliente);
}
