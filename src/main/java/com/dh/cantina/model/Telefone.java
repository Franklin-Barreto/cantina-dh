package com.dh.cantina.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String numero;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;


	private Telefone() {
	}

	private Telefone(String ddd, String numero,Cliente cliente) {
		this.ddd = ddd;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public static Telefone of(String ddd, String numero,Cliente cliente) {
		return new Telefone(ddd, numero,cliente);
	}
	
	

}
