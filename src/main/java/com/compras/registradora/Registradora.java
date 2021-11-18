package com.compras.registradora;

import java.math.BigDecimal;

import com.compras.Compra;
import com.compras.model.BancoDeDados;
import com.compras.model.Cliente;
import com.compras.model.Venda;
import com.compras.model.Vendedor;

public class Registradora {

	public Registradora() {

	}

	private Compra compra;
	private BigDecimal valorRecebido;
	private Vendedor vendedor;
	private Cliente cliente;

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	@Override
	public String toString() {
		return "Registradora [compra=" + getCompra() + ", valorRecebido=" + getValorRecebido() + "]";
	}

	public void efetivarVenda() {
		BigDecimal totalCompra = compra.getTotal();
		BigDecimal troco = valorRecebido.subtract(totalCompra);
		Venda venda = new Venda();
		venda.setTotalCompra(totalCompra);
		venda.setTroco(troco);
		venda.setVendedor(vendedor);
		venda.setCliente(cliente);
		
		BancoDeDados.addVenda(venda);
		
	}
}
