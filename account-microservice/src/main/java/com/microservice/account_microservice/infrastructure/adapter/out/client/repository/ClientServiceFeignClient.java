package com.microservice.account_microservice.infrastructure.adapter.out.client.repository;

import com.microservice.account_microservice.infrastructure.adapter.out.client.entity.ClientEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-microservice")
public interface ClientServiceFeignClient {

    @GetMapping("/api/v1/clientes/{id}")
    ResponseEntity<ClientEntity> getClientById(
            @PathVariable Long id
    );
}
