package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out;

import com.microservice.account_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountResponseDto {
    private String numeroCuenta;

    private String tipo;

    private Double saldoInicial;

    private Boolean estado;

    private String cliente;
}
