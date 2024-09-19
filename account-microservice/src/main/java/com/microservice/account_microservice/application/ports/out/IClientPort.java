package com.microservice.account_microservice.application.ports.out;

import com.microservice.account_microservice.domain.model.cliente.Cliente;

import java.util.List;

public interface IClientPort {

    Cliente getClient(Long id);

}
