package com.microservice.client_microservice.infrastructure.adapter.in.rest.dto.in;

import com.microservice.client_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientRequestDto {
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private Boolean estado;
    private AccountType tipoCuenta;
    private Double saldoInicial;
}
