package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in;

import com.microservice.account_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {
    private AccountType tipo;

    private Double saldoInicial;

    private Boolean estado;

    private Long clienteId;

}
