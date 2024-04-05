package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(ProdutoTamanhoId.class)
public class ProdutoTamanho {
	@Id
	private long id;
	@Id
	private long produto;
	private String tamanho;
	private long quantidade;

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

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public long getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
}