package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PagamentoVendaId.class)
public class PagamentoVenda {
	@Id
	private long id;
	@Id
	private long venda;
	private String bandeira;
	private String descricao;
	private double valorPagamento;
	private double valorTroco;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVenda() {
		return this.venda;
	}

	public void setVenda(long venda) {
		this.venda = venda;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBandeira() {
		return this.bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public double getValorPagamento() {
		return this.valorPagamento;
	}

	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public double getValorTroco() {
		return this.valorTroco;
	}

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}
}