package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in;

import com.microservice.account_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private String numeroCuenta;

    private AccountType tipo;

    private Double saldoInicial;

    private Boolean estado;

    private Long clienteId;

}
