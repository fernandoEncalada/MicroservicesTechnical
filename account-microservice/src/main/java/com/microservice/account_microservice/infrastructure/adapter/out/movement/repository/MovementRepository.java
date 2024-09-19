package com.microservice.account_microservice.infrastructure.adapter.out.movement.repository;

import com.microservice.account_microservice.infrastructure.adapter.out.movement.entity.MovementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {
    @Query("SELECT m FROM MovementEntity m WHERE m.cuenta.idCliente = :idCliente AND m.fecha BETWEEN :fechaInicio AND :fechaFin")
    Page<MovementEntity> findByIdClienteAndFechaBetween(@Param("idCliente") Long idCliente,
                                                        @Param("fechaInicio") Date fechaInicio,
                                                        @Param("fechaFin") Date fechaFin,
                                                        Pageable pageable);
}

