package com.joceano.javalazyloading.service.impl;

import com.joceano.javalazyloading.dto.PedidoItemDto;
import com.joceano.javalazyloading.dto.mapper.ObjectMapper;
import com.joceano.javalazyloading.model.PedidoItem;
import com.joceano.javalazyloading.repository.PedidoItemRepository;
import com.joceano.javalazyloading.service.PedidoItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {

    private final PedidoItemRepository pedidoItemRepository;

    public PedidoItemServiceImpl(PedidoItemRepository pedidoItemRepository) {
        this.pedidoItemRepository = pedidoItemRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoItemDto> findByPedidoId(Long id) {
        List<PedidoItem> pedidoItems = pedidoItemRepository.findByPedidoId(id);
        return ObjectMapper.mapList(pedidoItems, PedidoItemDto.class);
    }
}
