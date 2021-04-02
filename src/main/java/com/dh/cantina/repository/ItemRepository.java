package com.dh.cantina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.cantina.model.ItemPedido;

public interface ItemRepository extends JpaRepository<ItemPedido, Long> {

}
