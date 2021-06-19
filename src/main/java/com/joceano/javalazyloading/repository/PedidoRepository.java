package com.joceano.javalazyloading.repository;

import com.joceano.javalazyloading.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
