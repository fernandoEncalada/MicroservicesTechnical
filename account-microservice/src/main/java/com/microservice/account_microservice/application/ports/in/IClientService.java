package com.microservice.account_microservice.application.ports.in;

import com.microservice.account_microservice.domain.model.cliente.Cliente;

public interface IClientService {

    Cliente getClient(Long id);

}