package com.microservice.account_microservice.infrastructure.adapter.out.account;

import com.microservice.account_microservice.application.ports.out.IClientPort;
import com.microservice.account_microservice.application.ports.out.ICuentaPort;
import com.microservice.account_microservice.domain.model.cliente.Cliente;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import com.microservice.account_microservice.infrastructure.adapter.out.account.mapper.AccountMapper;
import com.microservice.account_microservice.infrastructure.adapter.out.account.repository.AccountRepository;
import com.microservice.account_microservice.infrastructure.exception.AccountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.microservice.account_microservice.domain.util.Util.generateAccountNumber;

@Component
@RequiredArgsConstructor
public class AccountAdapter implements ICuentaPort {
    private final AccountRepository accountRepository;
    private final IClientPort clientPort;

    @Override
    public AccountResponseDto create(AccountRequestDto cuenta) {
        Cliente client = clientPort.getClient(cuenta.getClienteId());

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setNumeroCuenta(generateAccountNumber());
        accountEntity.setTipoCuenta(cuenta.getTipo());
        accountEntity.setSaldoInicial(cuenta.getSaldoInicial());
        accountEntity.setEstado(cuenta.getEstado());
        accountEntity.setIdCliente(cuenta.getClienteId());

        AccountEntity savedEntity = accountRepository.save(accountEntity);

        return AccountMapper.toResponseDto(savedEntity, client.getNombre());
    }

    @Override
    public AccountResponseDto update(Long id, AccountRequestDto account) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new AccountException("Cuenta no encontrada con ID: " + id));
        Cliente client = clientPort.getClient(id);

        accountEntity.setTipoCuenta(account.getTipo());
        accountEntity.setSaldoInicial(account.getSaldoInicial());
        accountEntity.setEstado(account.getEstado());
        accountEntity.setIdCliente(account.getClienteId());

        AccountEntity updatedEntity = accountRepository.save(accountEntity);

        return AccountMapper.toResponseDto(updatedEntity, client.getNombre());
    }

    @Override
    public void delete(Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new AccountException("Cuenta no encontrada con ID: " + id));

        accountEntity.setEstado(false);

        accountRepository.save(accountEntity);
    }

    @Override
    public AccountResponseDto get(Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow();
        Cliente client = clientPort.getClient(id);

        return AccountMapper.toResponseDto(accountEntity, client.getNombre());
    }

    @Override
    public List<AccountResponseDto> getAll() {
        return accountRepository
                .findAll()
                .stream()
                .map(accountEntity -> {
                    Cliente client = clientPort.getClient(accountEntity.getIdCliente());
                    return AccountMapper.toResponseDto(accountEntity, client.getNombre());
                })
                .toList();
    }

    @Override
    public List<AccountResponseDto> getAccountsByClientId(Long idCliente) {
        Cliente client = clientPort.getClient(idCliente);
        List<AccountEntity> clientAccounts = accountRepository.findByIdCliente(idCliente);
        return clientAccounts.stream().map(account -> AccountMapper.toResponseDto(account, client.getNombre())).toList();
    }


}
