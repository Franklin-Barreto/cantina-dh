package com.dh.cantina.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cliente")
	@JsonIgnore
	Cliente cliente;

	private LocalDate dataCompra = LocalDate.now();

	@Transient
	private List<ItemPedido> itensPedido;

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public List<ItemPedido> getItensPedido() {
		return Collections.unmodifiableList(itensPedido);
	}

	public BigDecimal getValorTotal() {
		return itensPedido.stream().map(ItemPedido::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void addItem(ItemPedido item) {
		itensPedido.add(item);
	}

	public void setItens(List<ItemPedido> itens) {
		this.itensPedido = itens;
	}
}
