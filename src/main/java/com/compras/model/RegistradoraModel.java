package com.compras.model;

import com.compras.registradora.Registradora;

public class RegistradoraModel {

	public RegistradoraModel() {

	}

	public Registradora construirCenario() {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(1);
		vendedor.setNome("Vendedor A");
		
		Cliente cliente = new Cliente("Cliente 01");

		Registradora registradora = new Registradora();
		registradora.setVendedor(vendedor);
		registradora.setCliente(cliente);
		
		return registradora;
	}
}
