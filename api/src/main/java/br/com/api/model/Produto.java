package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private double preco;
	private double peso;
	private String ativo;
	private String utilizaEstoque;
	private int estoque;
	private String iFood;
	private String urlImage;
	private String segmento;
	private long marca;
	private String descricao;
	private long categoria;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataCriacao;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataAlteracao;

	public int getEstoque() {
		return this.estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public long getCategoria() {
		return this.categoria;
	}

	public void setCategoria(long categoria) {
		this.categoria = categoria;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return this.dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUtilizaEstoque() {
		return this.utilizaEstoque;
	}

	public void setUtilizaEstoque(String utilizaEstoque) {
		this.utilizaEstoque = utilizaEstoque;
	}

	public String getiFood() {
		return this.iFood;
	}

	public void setiFood(String iFood) {
		this.iFood = iFood;
	}

	public String getUrlImage() {
		return this.urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getSegmento() {
		return this.segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public long getMarca() {
		return this.marca;
	}

	public void setMarca(long marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}