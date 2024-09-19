package com.microservice.account_microservice.domain.model;

import com.microservice.account_microservice.infrastructure.exception.AccountException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movimiento {

    private Long id;
    private Account account;
    private Date fecha;
    private String tipoMovimiento;
    private Double valor;
    private Double saldo;

    public void validarSaldo(Double saldoInicial) {
        Double nuevoSaldo = saldoInicial + this.valor;
        if (nuevoSaldo < 0) {
            throw new AccountException("Saldo no disponible");
        }
    }

}
