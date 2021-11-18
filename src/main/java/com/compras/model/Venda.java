package com.compras.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Venda {
	private BigDecimal totalCompra;
	private BigDecimal troco;
	private Vendedor vendedor;
	private Cliente cliente;
	private LocalDate dataVenda;

	public Venda() {
		this.dataVenda = LocalDate.now();
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

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

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "Venda [totalCompra=" + getTotalCompra() + ", troco=" + getTroco() + ", vendedor=" + getVendedor()
				+ ", cliente=" + getCliente() + ", dataVenda=" + getDataVenda() + "]";
	}

}
