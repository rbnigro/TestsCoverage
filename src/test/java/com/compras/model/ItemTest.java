package com.compras.model;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.compras.Item;

public class ItemTest {

	@Test
	public void itemTest() {
		Item item = new Item();
		item.setNome("Nome Item");
		item.setValor(new BigDecimal(1.25));
		String expected = "Item [nome=Nome Item, valor=1.25]";
		assertTrue(expected.equals(item.toString()));
	}
}
