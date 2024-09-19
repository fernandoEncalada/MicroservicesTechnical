package com.microservice.account_microservice.application.service;

import com.microservice.account_microservice.application.ports.in.ICuentaService;
import com.microservice.account_microservice.application.ports.out.ICuentaPort;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.ClientResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaService implements ICuentaService {

    private final ICuentaPort cuentaPort;

    @Override
    public AccountResponseDto create(AccountRequestDto cuenta) {
        return cuentaPort.create(cuenta);
    }

    @Override
    public AccountResponseDto update(Long id, AccountRequestDto cuenta) {
        return cuentaPort.update(id, cuenta);
    }

    @Override
    public void delete(Long id) {
        cuentaPort.delete(id);
    }

    @Override
    public List<AccountResponseDto> getAccountsByClientId(Long idCliente) {
        return cuentaPort.getAccountsByClientId(idCliente);
    }

    @Override
    public AccountResponseDto get(Long id) {
        return cuentaPort.get(id);
    }

    @Override
    public List<AccountResponseDto> getAll() {
        return cuentaPort.getAll();
    }

    public void asociarClienteConCuenta(ClientResponseDto cliente) {
        AccountRequestDto requestDto = new AccountRequestDto();
        requestDto.setTipo(cliente.getTipoCuenta());
        requestDto.setClienteId(cliente.getIdCliente());
        requestDto.setEstado(true);
        requestDto.setSaldoInicial(cliente.getSaldoInicial());

        cuentaPort.create(requestDto);
    }
}
