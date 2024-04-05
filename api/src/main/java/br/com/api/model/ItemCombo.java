package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ItemComboId.class)
public class ItemCombo {
	@Id
	private long combo;
	@Id
	private long id;
	private long produto;
	private int quantidade;
	private double preco;

	public long getCombo() {
		return this.combo;
	}

	public void setCombo(long combo) {
		this.combo = combo;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProduto() {
		return this.produto;
	}

	public void setProduto(long produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}