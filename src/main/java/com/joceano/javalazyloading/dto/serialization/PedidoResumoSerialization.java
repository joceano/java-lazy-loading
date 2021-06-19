package com.joceano.javalazyloading.dto.serialization;

import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PedidoResumoSerialization {

    public PedidoResumoDto toDto(Pedido pedido) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoResumoDto.class);
    }
}
