package com.joceano.javalazyloading.controller;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoDto> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDto findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping("/{id}/resumo")
    public PedidoResumoDto findByIdResumo(@PathVariable Long id) {
        return pedidoService.findByIdResumo(id);
    }
}
