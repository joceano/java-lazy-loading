package com.joceano.javalazyloading.dto.serialization;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PedidoSerialization {

    public PedidoDto toDto(Pedido pedido) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoDto.class);
    }
}
