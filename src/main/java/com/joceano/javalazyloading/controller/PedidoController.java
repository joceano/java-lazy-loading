package com.joceano.javalazyloading.controller;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.service.PedidoService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/resumo")
    public List<PedidoResumoDto> findAllResumo() {
        return pedidoService.findAllResumo();
    }

    @GetMapping("/{id}")
    public PedidoDto findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping("/{id}/resumo")
    public PedidoResumoDto findByIdResumo(@PathVariable Long id) {
        return pedidoService.findByIdResumo(id);
    }

    @PostMapping
    public PedidoDto insert(@RequestBody PedidoDto pedidoDto) {
        return pedidoService.insert(pedidoDto);
    }
}
