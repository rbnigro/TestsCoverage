package com.compras.model;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.compras.Compra;
import com.compras.Item;

public class CompraTest {

	@Test
	public void compraTest() {
		Compra compra = new Compra();

		Item produtoA = new Item();
		produtoA.setNome("Produto A");
		produtoA.setValor(new BigDecimal(7.00));

		List<Item> listaItens = Arrays.asList(produtoA);
		
		compra.setItens(listaItens);

		String expected = "Compra [itens=[Item [nome=Produto A, valor=7]]]";
		
		assertTrue(expected.equals(compra.toString()));
	}
}
