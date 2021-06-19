package com.joceano.javalazyloading.controller;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDto> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDto findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }
}
