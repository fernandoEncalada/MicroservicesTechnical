package com.microservice.account_microservice.application.ports.out;

import com.microservice.account_microservice.domain.model.Movimiento;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.MovementRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.MovementResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IMovimientoPort {

    MovementResponseDto create(MovementRequestDto movimiento, AccountEntity account);

    MovementResponseDto update(Long id, MovementRequestDto movimiento);

    void delete(Long id);

    MovementResponseDto get(Long id);

    List<MovementResponseDto> getAll();

    Page<Movimiento> getMovimientosByClienteAndFecha(Long idCliente, Date fechaInicio, Date fechaFin, Pageable pageable);

}
