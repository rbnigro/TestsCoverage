package com.compras;

import java.math.BigDecimal;

public class Item {
	private String nome;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Item [nome=" + getNome() + ", valor=" + getValor() + "]";
	}

}
