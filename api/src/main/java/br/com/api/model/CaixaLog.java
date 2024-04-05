package br.com.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.util.Date;

@Entity
@IdClass(CaixaLogId.class)
public class CaixaLog {
	@Id
	private int usuario;
	private String descricao;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Id
	private Date data_registro;

	public int getUsuario() {
		return this.usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_registro() {
		return this.data_registro;
	}

	public void setData_registro(Date data_registro) {
		this.data_registro = data_registro;
	}
}