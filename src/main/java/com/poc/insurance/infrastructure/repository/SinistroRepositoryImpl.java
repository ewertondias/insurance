package com.poc.insurance.infrastructure.repository;

import com.poc.insurance.domain.sinistro.Sinistro;
import com.poc.insurance.domain.sinistro.repository.SinistroRepository;
import com.poc.insurance.infrastructure.factory.SinistroFactory;
import org.springframework.stereotype.Component;

@Component
public class SinistroRepositoryImpl implements SinistroRepository {

    private final SinistroJpaRepository sinistroJpaRepository;
    private final SinistroFactory sinistroFactory;

    public SinistroRepositoryImpl(final SinistroJpaRepository sinistroJpaRepository, final SinistroFactory sinistroFactory) {
        this.sinistroJpaRepository = sinistroJpaRepository;
        this.sinistroFactory = sinistroFactory;
    }

    @Override
    public Sinistro abrir(final Sinistro sinistro) {
        SinistroEntity sinistroEntity = sinistroFactory.toEntity(sinistro);
        SinistroEntity sinistroSalvo = sinistroJpaRepository.save(sinistroEntity);
        return sinistroFactory.toDomain(sinistroSalvo);
    }

}
