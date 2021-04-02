package com.dh.cantina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.cantina.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
