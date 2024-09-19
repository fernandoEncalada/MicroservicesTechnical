package com.microservice.account_microservice.infrastructure.adapter.out.movement;

import com.microservice.account_microservice.application.ports.out.IMovimientoPort;
import com.microservice.account_microservice.domain.model.Movimiento;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.MovementRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.MovementResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.entity.MovementEntity;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.mapper.MovementMapper;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.repository.MovementRepository;
import com.microservice.account_microservice.infrastructure.exception.AccountException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.microservice.account_microservice.infrastructure.adapter.out.movement.mapper.MovementMapper.toResponseDto;

@Component
@RequiredArgsConstructor
public class MovementAdapter implements IMovimientoPort {

    private final MovementRepository movementRepository;

    public MovementResponseDto create(MovementRequestDto movimiento, AccountEntity account) {
        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setFecha(new Date());
        movementEntity.setTipoMovimiento(movimiento.getTipoMovimiento());
        movementEntity.setValor(movimiento.getValor());
        movementEntity.setSaldo(movimiento.getSaldo());
        movementEntity.setCuenta(account);

        MovementEntity savedEntity = movementRepository.save(movementEntity);

        return toResponseDto(savedEntity);
    }

    @Override
    public MovementResponseDto update(Long id, MovementRequestDto movimiento) {
        MovementEntity movementEntity = movementRepository.findById(id)
                .orElseThrow(() -> new AccountException("Movimiento no encontrado con id: " + id));

        movementEntity.setTipoMovimiento(movimiento.getTipoMovimiento());
        movementEntity.setValor(movimiento.getValor());
        movementEntity.setSaldo(movimiento.getSaldo());

        MovementEntity updatedEntity = movementRepository.save(movementEntity);

        return toResponseDto(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        movementRepository.deleteById(id);
    }

    @Override
    public MovementResponseDto get(Long id) {
        MovementEntity movementEntity = movementRepository.findById(id).orElseThrow();
        return toResponseDto(movementEntity);
    }

    @Override
    public List<MovementResponseDto> getAll() {
        return movementRepository.findAll().stream()
                .map(MovementMapper::toResponseDto).toList();
    }

    @Override
    public Page<Movimiento> getMovimientosByClienteAndFecha(Long idCliente, Date fechaInicio, Date fechaFin, Pageable pageable) {
        Page<MovementEntity> movimientos = movementRepository.findByIdClienteAndFechaBetween(idCliente, fechaInicio, fechaFin, pageable);
        return movimientos.map(MovementMapper::toDomain);
    }

}
