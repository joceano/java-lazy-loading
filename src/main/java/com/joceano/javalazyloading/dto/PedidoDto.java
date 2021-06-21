package com.joceano.javalazyloading.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Long id;
    private String numero;
    private LocalDate dataEmissao;
    private List<PedidoItemDto> itens = new ArrayList<>();
}
