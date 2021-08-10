package com.joceano.javalazyloading.controller;

import com.joceano.javalazyloading.dto.PedidoItemDto;
import com.joceano.javalazyloading.service.PedidoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido-itens")
public class PedidoItemController {

    private final PedidoItemService pedidoItemService;

    public PedidoItemController(PedidoItemService pedidoItemService) {
        this.pedidoItemService = pedidoItemService;
    }

    @GetMapping("/{id}")
    public List<PedidoItemDto> findAll(@PathVariable Long id) {
        return pedidoItemService.findByPedidoId(id);
    }
}
