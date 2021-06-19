package com.joceano.javalazyloading.dto.error;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Error {

    private final String codigo;
    private final String mensagem;

    public Error(@NonNull String codigo, @NonNull String mensagem) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
    }
}
