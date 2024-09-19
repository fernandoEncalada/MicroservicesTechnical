package com.microservice.account_microservice.infrastructure.adapter.in.rest.controller;

import com.microservice.account_microservice.application.ports.in.ICuentaService;
import com.microservice.account_microservice.application.ports.in.IReportService;
import com.microservice.account_microservice.domain.model.Account;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final ICuentaService cuentaService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createCuenta(@RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.status(201).body(cuentaService.create(accountRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCuentaById(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.get(id));
    }

    @GetMapping("/buscar-por-cliente/{idCliente}")
    public ResponseEntity<?> getAccountsByClientId(@PathVariable(name = "idCliente") Long clientId) {
        return ResponseEntity.ok(cuentaService.getAccountsByClientId(clientId));
    }

    @GetMapping
    public ResponseEntity<?> getAllCuentas() {
        return ResponseEntity.ok(cuentaService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCuenta(@PathVariable Long id, @RequestBody AccountRequestDto accountRequestDto) {
        return ResponseEntity.ok(cuentaService.update(id, accountRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCuenta(@PathVariable Long id) {
        cuentaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
