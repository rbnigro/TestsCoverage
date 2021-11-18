package com.compras;

import java.math.BigDecimal;
import java.util.List;

public class Compra {
	
	private List<Item> itens;

	public Compra() {
		super();
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Compra [itens=" + itens + "]";
	}

	public BigDecimal getTotal() {
		return itens
				.stream()
				.map(Item::getValor)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
