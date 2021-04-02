package com.dh.cantina.model.input;

public class ItemPedidoInput {

	private Long produto;
	private int quantidade;

	public ItemPedidoInput(Long produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Long getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
