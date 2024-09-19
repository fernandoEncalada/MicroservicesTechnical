package com.microservice.account_microservice.infrastructure.adapter.in.rest.controller;

import com.microservice.account_microservice.application.ports.in.IMovimientoService;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.MovementRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movimientos")
@RequiredArgsConstructor
public class MovementController {

    private final IMovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<?> createMovimiento(@RequestBody MovementRequestDto movimiento) {
        return ResponseEntity.status(201).body(movimientoService.create(movimiento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.get(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllMovimientos() {

        return ResponseEntity.ok(movimientoService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovimiento(@PathVariable Long id, @RequestBody MovementRequestDto movimiento) {
        return ResponseEntity.ok(movimientoService.update(id, movimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovimiento(@PathVariable Long id) {
        movimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
