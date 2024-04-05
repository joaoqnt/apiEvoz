package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Mesa {
	@Id
	private long id;
	private String descricao;
	private int cliente;
	private String nomeCliente;
	private String statusOcupacao;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataCriacao;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dataAbertura;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date ultimoPedido;
	private double valorTotal;
	private String statusPagamento;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCliente() {
		return this.cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getStatusOcupacao() {
		return this.statusOcupacao;
	}

	public void setStatusOcupacao(String statusOcupacao) {
		this.statusOcupacao = statusOcupacao;
	}

	public Date getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatusPagamento() {
		return this.statusPagamento;
	}

	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getUltimoPedido() {
		return this.ultimoPedido;
	}

	public void setUltimoPedido(Date ultimoPedido) {
		this.ultimoPedido = ultimoPedido;
	}
}