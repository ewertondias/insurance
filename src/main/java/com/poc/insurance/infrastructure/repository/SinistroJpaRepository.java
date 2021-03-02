package com.poc.insurance.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinistroJpaRepository extends JpaRepository<SinistroEntity, Long> {
}
