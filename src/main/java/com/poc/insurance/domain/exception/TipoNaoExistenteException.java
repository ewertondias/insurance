package com.poc.insurance.domain.exception;

public class TipoNaoExistenteException extends RuntimeException {

    private static final long serialVersionUID = -1614352735475184722L;

    public TipoNaoExistenteException(String message) {
        super(message);
    }

}
