package com.microservice.account_microservice.infrastructure.adapter.out.account.repository;

import com.microservice.account_microservice.infrastructure.adapter.out.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    // Métodos personalizados, si es necesario

    List<AccountEntity> findByIdCliente(Long idCliente);
}
