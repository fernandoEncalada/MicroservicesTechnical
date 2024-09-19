package com.microservice.client_microservice.infrastructure.adapter.out.client.repository;

import com.microservice.client_microservice.infrastructure.adapter.out.client.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {}
