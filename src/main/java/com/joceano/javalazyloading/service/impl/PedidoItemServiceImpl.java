package com.joceano.javalazyloading.service.impl;

import com.joceano.javalazyloading.dto.PedidoItemDto;
import com.joceano.javalazyloading.dto.serialization.ObjectSerialization;
import com.joceano.javalazyloading.model.PedidoItem;
import com.joceano.javalazyloading.repository.PedidoItemRepository;
import com.joceano.javalazyloading.service.PedidoItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {

    private final PedidoItemRepository pedidoItemRepository;

    public PedidoItemServiceImpl(PedidoItemRepository pedidoItemRepository) {
        this.pedidoItemRepository = pedidoItemRepository;
    }

    @Override
    public List<PedidoItemDto> findByPedidoId(Long id) {
        List<PedidoItem> pedidoItems = pedidoItemRepository.findByPedidoId(id);
        return ObjectSerialization.toDtoList(pedidoItems, PedidoItemDto.class);
    }
}