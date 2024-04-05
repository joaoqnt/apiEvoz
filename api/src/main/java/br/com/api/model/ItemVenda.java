package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ItemVendaId.class)
public class ItemVenda {
	@Id
	private long id;
	@Id
	private long venda;
	private int produto;
	private String nomeProduto;
	private int quantidade;
	private double precoUnitario;
	private double preco;
	private String observacao;

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

	public int getProduto() {
		return this.produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
}