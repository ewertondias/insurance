package com.poc.insurance.domain.sinistro.service;

import com.poc.insurance.domain.sinistro.Sinistro;
import com.poc.insurance.domain.exception.UsuarioInativoException;
import com.poc.insurance.domain.sinistro.repository.SinistroRepository;

public class SinistroServiceImpl implements SinistroService {

    private final SinistroRepository sinistroRepository;

    public SinistroServiceImpl(SinistroRepository sinistroRepository) {
        this.sinistroRepository = sinistroRepository;
    }

    @Override
    public Sinistro abrir(final Sinistro sinistro) {
        if (sinistro.getUsuario().getStatus() != 1) {
            throw new UsuarioInativoException("Usuário não está ativo");
        }

        return sinistroRepository.abrir(sinistro).get();
    }

}
