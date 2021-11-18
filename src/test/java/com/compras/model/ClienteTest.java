package com.compras.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void clienteTest() {
		Cliente cliente = new Cliente("Nome Cli");
		String expected = "Cliente [nome=Nome Cli]";
		assertTrue(expected.equals(cliente.toString()));
	}
}
