package com.poc.insurance.domain.sinistro;

import com.poc.insurance.domain.usuario.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Sinistro {

    private Long id;
    private Integer tipo;
    private Date data;
    private String descricao;
    private Integer status;
    private Usuario usuario;

}
