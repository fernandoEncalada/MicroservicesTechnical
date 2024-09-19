package com.microservice.account_microservice.infrastructure.adapter.out.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {

    private String nombres;
    private String direccion;
    private String telefono;

}
