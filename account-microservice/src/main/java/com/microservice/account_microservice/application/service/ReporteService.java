package com.microservice.account_microservice.application.service;

import com.microservice.account_microservice.application.ports.in.IReportService;
import com.microservice.account_microservice.application.ports.out.IClientPort;
import com.microservice.account_microservice.application.ports.out.ICuentaPort;
import com.microservice.account_microservice.application.ports.out.IMovimientoPort;
import com.microservice.account_microservice.application.ports.out.IReportePort;
import com.microservice.account_microservice.domain.model.Movimiento;
import com.microservice.account_microservice.domain.model.cliente.Cliente;
import com.microservice.account_microservice.domain.model.enums.MovementType;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountResponseDto;
import com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.out.AccountStatusReportDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService implements IReportService {

    private final IMovimientoPort movimientoPort;
    private final IClientPort clientPort;

    @Override
    public Page<AccountStatusReportDTO> generarReporteEstadoCuenta(Long idCliente, Date fechaInicio, Date fechaFin, Pageable pageable) {
        Page<AccountStatusReportDTO> reporte = new PageImpl<>(new ArrayList<>());
        Cliente cliente = clientPort.getClient(idCliente);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Page<Movimiento> movimientos = movimientoPort.getMovimientosByClienteAndFecha(idCliente, fechaInicio, fechaFin, pageable);
        return movimientos.map(movimiento -> {
            AccountStatusReportDTO dto = new AccountStatusReportDTO();
            dto.setFecha(sdf.format(movimiento.getFecha()));
            dto.setCliente(cliente.getNombre());
            dto.setNumeroCuenta(movimiento.getAccount().getNumeroCuenta());
            dto.setTipo(movimiento.getAccount().getTipoCuenta().getDescription());
            dto.setSaldoInicial(movimiento.getAccount().getSaldoInicial());
            dto.setEstado(movimiento.getAccount().getEstado());
            dto.setMovimiento(movimiento.getTipoMovimiento().equals(MovementType.RETIRO.getDescription())
                    ?  -movimiento.getValor()
                    : movimiento.getValor());
            dto.setSaldoDisponible(movimiento.getSaldo());

            return dto;
        });
    }
}
