package com.poc.insurance.domain.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private Integer status;

}
