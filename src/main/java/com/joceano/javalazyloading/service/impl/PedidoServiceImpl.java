package com.joceano.javalazyloading.service.impl;

import com.joceano.javalazyloading.dto.PedidoDto;
import com.joceano.javalazyloading.dto.PedidoResumoDto;
import com.joceano.javalazyloading.dto.mapper.ObjectModelMapper;
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
        return ObjectModelMapper.mapList(pedidos, PedidoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidoResumoDto> findAllResumo() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ObjectModelMapper.mapList(pedidos, PedidoResumoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoDto findById(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Pedido de código %d não encontrado", id)));
        return ObjectModelMapper.map(pedido, PedidoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PedidoResumoDto findByIdResumo(Long id) {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Pedido de código %d não encontrado", id)));
        return ObjectModelMapper.map(pedido, PedidoResumoDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PedidoDto insert(PedidoDto pedidoDto) {
        var pedido = ObjectModelMapper.map(pedidoDto, Pedido.class);
        var pedidoSalvo = pedidoRepository.save(pedido);
        return ObjectModelMapper.map(pedidoSalvo, PedidoDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PedidoDto update(PedidoDto pedidoDto) {
        if (!pedidoRepository.existsById(pedidoDto.getId()))
            throw new NoResultException(String.format("Pedido de código %d não encontrado", pedidoDto.getId()));
        var pedido = ObjectModelMapper.map(pedidoDto, Pedido.class);
        var pedidoSalvo = pedidoRepository.save(pedido);
        return ObjectModelMapper.map(pedidoSalvo, PedidoDto.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        if (!pedidoRepository.existsById(id))
            throw new NoResultException(String.format("Pedido de código %d não encontrado", id));
        pedidoRepository.deleteById(id);
    }

}
