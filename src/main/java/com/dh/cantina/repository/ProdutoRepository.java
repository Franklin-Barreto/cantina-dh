package com.dh.cantina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.cantina.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
