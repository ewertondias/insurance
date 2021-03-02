package com.poc.insurance.domain.sinistro;

import com.poc.insurance.domain.exception.TipoNaoExistenteException;

import java.util.Optional;
import java.util.stream.Stream;

public enum SinistroTipoEnum {

    COLISAO(1, "Colisão"),
    ROUBO_FURTO(2, "Roubo e furto");

    private final Integer tipo;
    private final String descricao;

    SinistroTipoEnum(Integer tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SinistroTipoEnum getByTipo(final Integer tipo) {
        Optional<SinistroTipoEnum> sinistro = Stream.of(SinistroTipoEnum.values())
            .filter(s -> s.getTipo().equals(tipo))
            .findFirst();

        if (sinistro.isEmpty()) {
            throw new TipoNaoExistenteException("Tipo de sinistro não existente");
        }

        return sinistro.get();
    }

}
