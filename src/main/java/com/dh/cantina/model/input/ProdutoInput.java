package com.dh.cantina.model.input;

public class ProdutoInput {

	private Double preco;
	private String descricao;
	private Integer categoria;
	
	
	
	public ProdutoInput(Double preco, String descricao, Integer categoria) {
		this.preco = preco;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}
	
	public Integer getCategoria() {
		return categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
