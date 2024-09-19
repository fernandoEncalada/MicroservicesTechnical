package com.microservice.account_microservice.infrastructure.adapter.out.movement.entity;

import com.microservice.account_microservice.domain.model.enums.MovementType;
import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "movimientos")
@Data
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @Enumerated(EnumType.STRING)
    private MovementType tipoMovimiento;

    private Double valor;

    private Double saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private AccountEntity cuenta;
}
