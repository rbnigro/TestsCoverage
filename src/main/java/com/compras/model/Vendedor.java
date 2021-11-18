package com.compras.model;

public class Vendedor {

	private int id;
	private String nome;

	public Vendedor() {

	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + getId() + ", nome=" + getNome() + "]";
	}
}
