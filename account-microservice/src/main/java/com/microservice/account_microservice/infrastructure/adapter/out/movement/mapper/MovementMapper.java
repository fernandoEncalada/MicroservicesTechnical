package com.microservice.account_microservice.infrastructure.adapter.out.movement.mapper;

import com.microservice.account_microservice.domain.model.Account;
import com.microservice.account_microservice.domain.model.Movimiento;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.MovementResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.entity.MovementEntity;

public class MovementMapper {

    public static Movimiento toDomain(MovementEntity movementEntity) {
        return new Movimiento(
            movementEntity.getId(),
            new Account(movementEntity.getCuenta().getId(), movementEntity.getCuenta().getNumeroCuenta(),
                    movementEntity.getCuenta().getTipoCuenta(), movementEntity.getCuenta().getSaldoInicial(),
                    movementEntity.getCuenta().getEstado(), movementEntity.getCuenta().getIdCliente()),
            movementEntity.getFecha(),
            movementEntity.getTipoMovimiento().getDescription(),
            movementEntity.getValor(),
            movementEntity.getSaldo()
        );
    }

    public static MovementResponseDto toResponseDto(MovementEntity movementEntity) {
        return new MovementResponseDto(
                movementEntity.getId(),
                movementEntity.getCuenta().getNumeroCuenta(),
                movementEntity.getCuenta().getTipoCuenta().getDescription(),
                movementEntity.getCuenta().getSaldoInicial(),
                movementEntity.getCuenta().getEstado(),
                movementEntity.getTipoMovimiento().getDescription() + " de " + Math.abs(movementEntity.getValor())
        );
    }
}
