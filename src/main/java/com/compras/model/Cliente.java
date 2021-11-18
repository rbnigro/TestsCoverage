package com.compras.model;

public class Cliente {
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + getNome() + "]";
	}
}
