package com.compras.registradora;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.compras.Compra;
import com.compras.Item;
import com.compras.model.BancoDeDados;
import com.compras.model.Cliente;
import com.compras.model.RegistradoraModel;
import com.compras.model.Vendedor;

public class RegistradoraTest {
	
	@Mock
	Item item;
	
	private Vendedor vendedor;
	
	private Cliente cliente;
	
	private Item produtoA;
	private Item produtoB;
	
	private Compra compra;
	
	private RegistradoraModel registradoramodel; 
	
	@Before
	public void setup() {
		produtoA = new Item();
		produtoA.setNome("Produto A");
		produtoA.setValor(new BigDecimal(7.00));

		produtoB = new Item();
		produtoB.setNome("Produto B");
		produtoB.setValor(new BigDecimal(6.50));
		
		List<Item> listaItens = Arrays.asList(produtoA, produtoB);
		
		compra = new Compra();
		compra.setItens(listaItens);
		
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1);
		vendedor.setNome("Vendedor A");
		
		Cliente cliente = new Cliente("Nome Cli");
	}
	
	@Test
	public void deveRegistrarVendaNoBanco() {
		// Input
		RegistradoraModel registradoraModel = new RegistradoraModel();
		
		Registradora registradora = new Registradora();
		registradora = registradoraModel.construirCenario();
		registradora.setCompra(compra);
		registradora.setValorRecebido(new BigDecimal(13.50));
		registradora.setVendedor(vendedor);
		registradora.setCliente(cliente);
		
		// Act
		registradora.efetivarVenda();
		
		// Resultado
		assertEquals(1, BancoDeDados.vendas.size());
		assertEquals(new BigDecimal(13.50), BancoDeDados.vendas.get(0).getTotalCompra());
		assertEquals(new BigDecimal(0.0), BancoDeDados.vendas.get(0).getTroco());
		assertEquals("Vendedor A", BancoDeDados.vendas.get(0).getVendedor().getNome());
		assertEquals("Nome Cli", BancoDeDados.vendas.get(0).getCliente().getNome());
		assertEquals(LocalDate.now(), BancoDeDados.vendas.get(0).getDataVenda());
		
//		https://www.youtube.com/watch?v=W3fSgHrBzek
	}
}
