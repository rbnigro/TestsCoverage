package com.compras.registradora;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.compras.Compra;
import com.compras.Item;
import com.compras.model.BancoDeDados;
import com.compras.model.RegistradoraModel;

public class RegistradoraTest {
	
	@Mock
	Item item;
	
	private Item produtoA;
	private Item produtoB;
	
	private Compra compra;
	
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
		
	}
	
	@Test
	public void deveRegistrarVendaNoBanco() {
		// Input
		RegistradoraModel registradoraModel = new RegistradoraModel();
		
		Registradora registradora = new Registradora();
		registradora = registradoraModel.construirCenario();
		registradora.setCompra(compra);
		registradora.setValorRecebido(new BigDecimal(13.50));
		
		// Act
		registradora.efetivarVenda();
		
		// Resultado
		assertEquals(1, BancoDeDados.vendas.size());
		assertEquals(new BigDecimal(13.50), BancoDeDados.vendas.get(0).getTotalCompra());
		
		DecimalFormat decimalFormat = new DecimalFormat("0,0");
		String Zero = decimalFormat.format(0);
		
		assertEquals(new BigDecimal(Zero), BancoDeDados.vendas.get(0).getTroco());
		
		assertEquals("Vendedor A", BancoDeDados.vendas.get(0).getVendedor().getNome());
		assertEquals("Cliente 01", BancoDeDados.vendas.get(0).getCliente().getNome());
		assertEquals(LocalDate.now(), BancoDeDados.vendas.get(0).getDataVenda());
		
//		https://www.youtube.com/watch?v=W3fSgHrBzek
	}
	
	@Test
	public void naoDeveRegistrarVenda() {
		// Input
		RegistradoraModel registradoraModel = new RegistradoraModel();
		
		Registradora registradora = new Registradora();
		registradora = registradoraModel.construirCenario();
		registradora.setCompra(compra);
		registradora.setValorRecebido(new BigDecimal(13.00));
		
		// Act
		registradora.efetivarVenda();
		
		//Assertions.ass
	}
}
