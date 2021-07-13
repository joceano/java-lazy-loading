package com.joceano.javalazyloading.factory;

import com.joceano.javalazyloading.dto.ItemDto;
import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoItemDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class PedidoFactoryTest {

    public PedidoDto getPedidoDto() {
        return PedidoDto.builder()
                .id(3L)
                .numero("333")
                .dataEmissao(LocalDate.now())
                .itens(this.getPedidoItensDto())
                .build();
    }

    private List<PedidoItemDto> getPedidoItensDto() {
        var pedidoItemDto = PedidoItemDto.builder()
                .id(99L)
                .item(this.getItemDto())
                .quantidade(BigDecimal.ONE)
                .valorUnitario(BigDecimal.TEN)
                .valorTotal(BigDecimal.TEN)
                .build();
        return Collections.singletonList(pedidoItemDto);
    }

    private ItemDto getItemDto() {
        return ItemDto.builder()
                .id(1L)
                .descricao("Item Teste")
                .unidade("Un")
                .build();
    }
}
