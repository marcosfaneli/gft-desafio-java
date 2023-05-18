package com.mfaneli.usuarios.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroCampo {
    private final String campo;
    private final String mensagem;
}
