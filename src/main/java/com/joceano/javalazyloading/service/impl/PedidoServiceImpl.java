package com.joceano.javalazyloading.service.impl;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.dto.serialization.ObjectSerialization;
import com.joceano.javalazyloading.model.Pedido;
import com.joceano.javalazyloading.repository.PedidoRepository;
import com.joceano.javalazyloading.service.PedidoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoDto> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ObjectSerialization.toDtoList(pedidos, PedidoDto.class);
    }

    @Override
    public List<PedidoResumoDto> findAllResumo() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ObjectSerialization.toDtoList(pedidos, PedidoResumoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoDto findById(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Pedido de código %d não encontrado", id)));
        return ObjectSerialization.toDto(pedido, PedidoDto.class);
    }

    @Override
    public PedidoResumoDto findByIdResumo(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Pedido de código %d não encontrado", id)));
        return ObjectSerialization.toDto(pedido, PedidoResumoDto.class);
    }
}
