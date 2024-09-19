package com.microservice.account_microservice.infrastructure.adapter.in.rest.dto.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.microservice.account_microservice.domain.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponseDto {

    private String nombres;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private Boolean estado;
    private AccountType tipoCuenta;
    private Double saldoInicial;
    private Long idCliente;

    public ClientResponseDto(String nombre, String direccion, String telefono, String contrasenia, Boolean estado) {
        this.nombres = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public ClientResponseDto(Long id, Double saldoInicial, AccountType tipoCuenta) {
        this.idCliente = id;
        this.saldoInicial = saldoInicial;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "ClientResponseDto{" +
                "nombres='" + nombres + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", estado=" + estado +
                ", tipoCuenta=" + tipoCuenta +
                ", saldoInicial=" + saldoInicial +
                ", idCliente=" + idCliente +
                '}';
    }
}
