package com.poc.insurance.domain.sinistro.service;

import com.poc.insurance.domain.sinistro.Sinistro;
import com.poc.insurance.domain.sinistro.SinistroTipoEnum;
import com.poc.insurance.domain.usuario.Usuario;
import com.poc.insurance.infrastructure.factory.SinistroFactory;
import com.poc.insurance.infrastructure.repository.SinistroEntity;
import com.poc.insurance.infrastructure.repository.SinistroJpaRepository;
import com.poc.insurance.infrastructure.repository.SinistroRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

class SinistroServiceTest {

    private static SinistroFactory sinistroFactory;
    private static SinistroJpaRepository sinistroJpaRepositoryMock;

    @BeforeAll
    static void setup() {
        sinistroJpaRepositoryMock = Mockito.mock(SinistroJpaRepository.class);
        sinistroFactory = new SinistroFactory();
    }

    @Test
    void dadoUmUsuarioAtivo_quandoUsuarioSolicitarAbrirSinistro_entaoDeveAbrirUmSinistroComSucesso() {
        // Dado
        Usuario usuario = new Usuario();
        usuario.setStatus(1);

        SinistroEntity sinistroEntity = new SinistroEntity();
        sinistroEntity.setTipo(1);
        sinistroEntity.setData(new Date());
        sinistroEntity.setDescricao("Colisão na marginal pinheiros 1");
        sinistroEntity.setStatus(1);

        Sinistro sinistro = new Sinistro();
        sinistro.setTipo(1);
        sinistro.setData(new Date());
        sinistro.setDescricao("Colisão na marginal pinheiros 1");
        sinistro.setStatus(1);
        sinistro.setUsuario(usuario);

        Mockito.when(sinistroJpaRepositoryMock.save(Mockito.any())).thenReturn(sinistroEntity);

        // Quando
        SinistroService sinistroService = new SinistroServiceImpl(
            new SinistroRepositoryImpl(sinistroJpaRepositoryMock, sinistroFactory));
        sinistroService.abrir(sinistro);

        // Entao
        Assertions.assertNotNull(sinistro);
        Assertions.assertEquals(1, sinistro.getStatus());
    }

}
