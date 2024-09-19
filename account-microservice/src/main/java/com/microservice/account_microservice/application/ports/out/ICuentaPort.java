package com.microservice.account_microservice.application.ports.out;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;

import java.util.List;

public interface ICuentaPort {

    AccountResponseDto create(AccountRequestDto cuenta);

    AccountResponseDto update(Long id, AccountRequestDto cuenta);

    void delete(Long id);

    AccountResponseDto get(Long id);

    List<AccountResponseDto> getAll();

    List<AccountResponseDto> getAccountsByClientId(Long idCliente);
}
