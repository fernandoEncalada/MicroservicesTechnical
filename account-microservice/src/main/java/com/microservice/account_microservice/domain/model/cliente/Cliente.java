package com.microservice.account_microservice.domain.model.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona {

    private String contrasenia;
    private Boolean estado;

}
