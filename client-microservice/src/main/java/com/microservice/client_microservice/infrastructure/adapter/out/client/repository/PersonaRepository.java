package com.microservice.client_microservice.infrastructure.adapter.out.client.repository;

import com.microservice.client_microservice.infrastructure.adapter.out.client.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByIdentificacion(String identificacion);
}
