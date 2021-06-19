package com.joceano.javalazyloading.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResumoDto {

    private Long id;
    private String numero;
    private LocalDate dataEmissao;
}
