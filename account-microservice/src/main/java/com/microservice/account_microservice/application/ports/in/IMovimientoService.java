package com.microservice.account_microservice.application.ports.in;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.MovementRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.MovementResponseDto;

import java.util.List;

public interface IMovimientoService {

    MovementResponseDto create(MovementRequestDto movimiento);

    MovementResponseDto get(Long id);
    
    List<MovementResponseDto> getAll();

    MovementResponseDto update(Long id, MovementRequestDto movimiento);
    
    void delete(Long id);
}
