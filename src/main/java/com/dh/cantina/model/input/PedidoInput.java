package com.dh.cantina.model.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoInput {

	private Long cliente;
	List<ItemPedidoInput> itens = new ArrayList<>();
	
	
	public PedidoInput(Long cliente, List<ItemPedidoInput> itens) {
		this.cliente = cliente;
		this.itens = itens;
	}

	public Long getCliente() {
		return cliente;
	}

	public List<ItemPedidoInput> getItens() {
		return Collections.unmodifiableList(itens);
	}
}
