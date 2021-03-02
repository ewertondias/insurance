package com.poc.insurance.domain.exception;

public class UsuarioInativoException extends RuntimeException {

    private static final long serialVersionUID = 7852838234048165410L;

    public UsuarioInativoException(String message) {
        super(message);
    }
}
