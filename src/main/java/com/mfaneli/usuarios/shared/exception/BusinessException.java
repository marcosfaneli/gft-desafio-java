package com.mfaneli.usuarios.shared.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem) {
        super(mensagem);
    }
}
