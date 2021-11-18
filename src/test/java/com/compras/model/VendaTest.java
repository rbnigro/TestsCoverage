package com.compras.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class VendaTest {

	@Test
	public void vendaTest() {
		Cliente cliente = new Cliente("Nome Cli");
		
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1);
		vendedor.setNome("Vendedor A");
		
		Venda venda = new Venda();
		venda.setTotalCompra(new BigDecimal(3.50));
		venda.setTroco(new BigDecimal(1.50));
		venda.setVendedor(vendedor);
		venda.setCliente(cliente);
		venda.setDataVenda(LocalDate.of(2021, 11, 18));
		
		String expected = "Venda [totalCompra=3.50, troco=1.50 vendedor=Vendedor A, cliente=Nome Cli, dataVenda=18/11/2021]";
		assertEquals(expected.compareTo(venda.toString()), 4); 
	}
}
