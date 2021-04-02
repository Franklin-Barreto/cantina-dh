package com.dh.cantina.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal preco;
	private String descricao;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_categoria")
	private Categoria categoria;

	public Produto() {
	}

	public Produto(String descricao, Double preco, Categoria categoria) {
		this.descricao = descricao;
		this.preco = new BigDecimal(preco);
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
