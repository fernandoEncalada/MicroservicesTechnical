package com.microservice.account_microservice.infrastructure.adapter.out.account.entity;

import com.microservice.account_microservice.domain.model.enums.AccountType;
import com.microservice.account_microservice.infrastructure.adapter.out.movement.entity.MovementEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cuentas")
@Data
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    private AccountType tipoCuenta;

    private Double saldoInicial;
    private Boolean estado;
    private Long idCliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovementEntity> movimientos;  // Relación con Movimientos
}
