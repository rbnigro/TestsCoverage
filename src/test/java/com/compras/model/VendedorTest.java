package com.compras.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VendedorTest {

	@Test
	public void vendedorTest() {
		
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1);
		vendedor.setNome("Nome Vendedor");
		
		String expected = "Vendedor [id=1, nome=Nome Vendedor]";
		
		assertTrue(expected.equals(vendedor.toString()));
	}
}
