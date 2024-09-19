package com.microservice.account_microservice.infrastructure.adapter.in.rest.controller;

import com.microservice.account_microservice.application.ports.in.ICuentaService;
import com.microservice.account_microservice.application.ports.in.IReportService;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in.AccountRequestDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountStatusReportDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor
public class ReportController {

    private final IReportService reportService;

    @GetMapping
    public ResponseEntity<?> getStatusAccountReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin,
            @RequestParam Long idCliente,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sortDirection) {
        Sort.Direction direction = sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "fecha"));

        Page<AccountStatusReportDTO> reporte = reportService.generarReporteEstadoCuenta(idCliente, fechaInicio, fechaFin, pageable);

        return ResponseEntity.ok(reporte);
    }
}

