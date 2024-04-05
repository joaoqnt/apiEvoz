package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Conexao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tenant;
	private String esquema;
	private String ativo;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenant() {
		return this.tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getEsquema() {
		return this.esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String toString() {
		return "{id:" + this.id + ", tenant:" + this.tenant + ", esquema:" + this.esquema + ", ativo:" + this.ativo
				+ "}";
	}
}