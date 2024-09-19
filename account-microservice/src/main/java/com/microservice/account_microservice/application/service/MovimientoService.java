package com.microservice.account_microservice.application.service;

import com.microservice.account_microservice.application.ports.in.IMovimientoService;
import com.microservice.account_microservice.application.ports.out.ICuentaPort;
import com.microservice.account_microservice.application.ports.out.IMovimientoPort;
import com.microservice.account_microservice.domain.model.enums.MovementType;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.MovementRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.MovementResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import com.microservice.account_microservice.infrastructure.adapter.out.account.repository.AccountRepository;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.entity.MovementEntity;
import com.microservice.account_microservice.infrastructure.exception.AccountException;
import com.microservice.account_microservice.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoService implements IMovimientoService {

    private final IMovimientoPort movimientoPort;
    private final ICuentaPort cuentaPort;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public MovementResponseDto create(MovementRequestDto movimiento) {
        Optional<AccountEntity> cuentaOptional = accountRepository.findById(movimiento.getIdCuenta());
        if (cuentaOptional.isEmpty()) throw new DataNotFoundException("Cuenta no encontrada con ID: " + movimiento.getIdCuenta());
        AccountEntity account = cuentaOptional.get();

        AccountRequestDto requestDto = new AccountRequestDto();
        requestDto.setTipo(account.getTipoCuenta());
        requestDto.setEstado(account.getEstado());
        requestDto.setClienteId(account.getIdCliente());
        requestDto.setNumeroCuenta(account.getNumeroCuenta());

        Double total;
        if (movimiento.getTipoMovimiento().equals(MovementType.RETIRO)){
            Double valor = -movimiento.getValor();
            movimiento.setSaldo(account.getSaldoInicial() + valor);
            requestDto.setSaldoInicial(account.getSaldoInicial() + valor);
            movimiento.setValor(-movimiento.getValor());
            total = account.getSaldoInicial() + valor;
        } else {
            movimiento.setSaldo(account.getSaldoInicial() + movimiento.getValor());
            requestDto.setSaldoInicial(account.getSaldoInicial() + movimiento.getValor());
            total = account.getSaldoInicial() + movimiento.getValor();
        }

        if (total < 0) throw new AccountException("Saldo no disponible");

        MovementResponseDto movementResponseDto = movimientoPort.create(movimiento, account);
        cuentaPort.update(movimiento.getIdCuenta(), requestDto);

        return movementResponseDto;
    }

    @Transactional
    @Override
    public MovementResponseDto update(Long id, MovementRequestDto movimiento) {
        return movimientoPort.update(id, movimiento);
    }

    @Override
    public void delete(Long id) {
        movimientoPort.delete(id);
    }

    @Override
    public MovementResponseDto get(Long id) {
        return movimientoPort.get(id);
    }

    @Override
    public List<MovementResponseDto> getAll() {
        return movimientoPort.getAll();
    }
}
