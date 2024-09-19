package com.microservice.account_microservice.domain.model;

import com.microservice.account_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Account {

    private Long id;
    private String numeroCuenta;
    private AccountType tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Long idCliente;

}
