package com.dh.cantina.model.input;

public class ClienteInput {

	private String nome;
	private String ddd;
	private String numero;

	public ClienteInput(String nome, String ddd, String numero) {
		this.nome = nome;
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}
}
