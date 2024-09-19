package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
