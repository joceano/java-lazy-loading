package com.joceano.javalazyloading.service;

import com.joceano.javalazyloading.dto.PedidoItemDto;

import java.util.List;

public interface PedidoItemService {
    List<PedidoItemDto> findByPedidoId(Long id);
}
