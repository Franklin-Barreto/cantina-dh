package com.dh.cantina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.cantina.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
