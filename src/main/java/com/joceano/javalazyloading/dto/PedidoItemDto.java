package com.joceano.javalazyloading.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoItemDto {
    private Long id;
    private ItemDto item;
    private BigDecimal quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    @JsonBackReference
    private PedidoDto pedido;
}
