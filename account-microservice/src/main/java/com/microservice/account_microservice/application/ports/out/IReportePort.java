package com.microservice.account_microservice.application.ports.out;

import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountStatusReportDTO;

import java.util.Date;
import java.util.List;

public interface IReportePort {
    List<AccountStatusReportDTO> generarReporteEstadoCuenta(Long idCliente, Date fechaInicio, Date fechaFin);
}
