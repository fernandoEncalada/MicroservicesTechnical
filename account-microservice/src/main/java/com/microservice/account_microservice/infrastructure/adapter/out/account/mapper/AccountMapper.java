package com.microservice.account_microservice.infrastructure.adapter.out.account.mapper;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;

public class AccountMapper {

    public static AccountResponseDto toResponseDto(AccountEntity accountEntity, String clientName) {
        return new AccountResponseDto(
                accountEntity.getNumeroCuenta(),
                accountEntity.getTipoCuenta().getDescription(),
                accountEntity.getSaldoInicial(),
                accountEntity.getEstado(),
                clientName
        );
    }
}
