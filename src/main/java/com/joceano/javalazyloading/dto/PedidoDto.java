package com.joceano.javalazyloading.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
    private Long id;
    private String numero;
    private LocalDate dataEmissao;
    @JsonManagedReference
    private List<PedidoItemDto> itens = new ArrayList<>();
}
