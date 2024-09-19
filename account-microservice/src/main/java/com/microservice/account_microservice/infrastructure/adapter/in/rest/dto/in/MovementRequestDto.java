package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in;

import com.microservice.account_microservice.domain.model.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovementRequestDto {

    private Long idCuenta;
    private MovementType tipoMovimiento;
    private Double valor;
    private Double saldo;
}
