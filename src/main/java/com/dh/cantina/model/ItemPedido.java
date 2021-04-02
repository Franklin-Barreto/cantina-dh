package com.dh.cantina.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "fk_produto")
	private Produto produto;

	private BigDecimal preco;

	private int quantidade;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pedido")
	private Pedido pedido;
	
	public ItemPedido() {};

	public ItemPedido(Produto produto, BigDecimal preco, int quantidade, Pedido pedido) {
		this.produto = produto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.pedido = pedido;
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

}
