package com.poc.insurance.infrastructure.factory;

import com.poc.insurance.domain.sinistro.Sinistro;
import com.poc.insurance.domain.sinistro.SinistroTipoEnum;
import com.poc.insurance.infrastructure.repository.SinistroEntity;
import org.springframework.stereotype.Component;

@Component
public class SinistroFactory {

    public SinistroEntity toEntity(final Sinistro sinistro) {
        SinistroEntity sinistroEntity = new SinistroEntity();
        sinistroEntity.setId(sinistro.getId());
        sinistroEntity.setTipo(SinistroTipoEnum.getByTipo(sinistro.getTipo()).getTipo());
        sinistroEntity.setData(sinistro.getData());
        sinistroEntity.setDescricao(sinistro.getDescricao());
        sinistroEntity.setStatus(sinistro.getStatus());

        return sinistroEntity;
    }

    public Sinistro toDomain(final SinistroEntity sinistroEntity) {
        Sinistro sinistro = new Sinistro();
        sinistro.setId(sinistroEntity.getId());
        sinistro.setTipo(sinistroEntity.getTipo());
        sinistro.setData(sinistroEntity.getData());
        sinistro.setDescricao(sinistroEntity.getDescricao());
        sinistro.setStatus(sinistroEntity.getStatus());

        return sinistro;
    }

}
