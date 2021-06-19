package com.joceano.javalazyloading.service.impl;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.dto.serialization.PedidoResumoSerialization;
import com.joceano.javalazyloading.dto.serialization.PedidoSerialization;
import com.joceano.javalazyloading.model.Pedido;
import com.joceano.javalazyloading.repository.PedidoRepository;
import com.joceano.javalazyloading.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoSerialization pedidoSerialization;
    private final PedidoResumoSerialization pedidoResumoSerialization;
    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoSerialization pedidoSerialization,
                             PedidoResumoSerialization pedidoResumoSerialization,
                             PedidoRepository pedidoRepository) {
        this.pedidoSerialization = pedidoSerialization;
        this.pedidoResumoSerialization = pedidoResumoSerialization;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<PedidoDto> findAll() {
        return null;
    }

    @Override
    public PedidoDto findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedidoSerialization.toDto(pedido);
    }

    @Override
    public PedidoResumoDto findByIdResumo(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        return pedidoResumoSerialization.toDto(pedido);
    }
}
