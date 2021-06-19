package com.joceano.javalazyloading.service;

import com.joceano.javalazyloading.dto.PedidoDto;

import java.util.List;

public interface PedidoService {

    List<PedidoDto> findAll();
    PedidoDto findById(Long id);
}
