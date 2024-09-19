package com.microservice.account_microservice.application.ports.in;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountStatusReportDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IReportService {
    Page<AccountStatusReportDTO> generarReporteEstadoCuenta(Long idCliente, Date fechaInicio, Date fechaFin, Pageable pageable);

}
