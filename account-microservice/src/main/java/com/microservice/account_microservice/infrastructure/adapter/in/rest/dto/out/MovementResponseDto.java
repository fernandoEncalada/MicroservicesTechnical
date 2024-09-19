package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MovementResponseDto {
    private Long id;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private Boolean estado;
    private String movimiento;
}
