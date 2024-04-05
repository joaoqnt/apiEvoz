package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String cnpj;
	private String iCredentials;
	private String iClientId;
	private String iClientSecret;
	private String iLojaId;
	private String segmento;
	private String utiliza_ifood;
	private String apelidoEmpresa;
	private String whatsApp;
	private String email;
	private String instagram;
	private String facebook;
	private String descricao;
	private String urlLogo;
	private String urlBanner;
	private String urlLoja;

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

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getiCredentials() {
		return this.iCredentials;
	}

	public void setiCredentials(String iCredentials) {
		this.iCredentials = iCredentials;
	}

	public String getiClientId() {
		return this.iClientId;
	}

	public void setiClientId(String iClientId) {
		this.iClientId = iClientId;
	}

	public String getiClientSecret() {
		return this.iClientSecret;
	}

	public void setiClientSecret(String iClientSecret) {
		this.iClientSecret = iClientSecret;
	}

	public String getiLojaId() {
		return this.iLojaId;
	}

	public void setiLojaId(String iLojaId) {
		this.iLojaId = iLojaId;
	}

	public String getSegmento() {
		return this.segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getUtiliza_ifood() {
		return this.utiliza_ifood;
	}

	public void setUtiliza_ifood(String utiliza_ifood) {
		this.utiliza_ifood = utiliza_ifood;
	}

	public String getApelidoEmpresa() {
		return this.apelidoEmpresa;
	}

	public void setApelidoEmpresa(String apelidoEmpresa) {
		this.apelidoEmpresa = apelidoEmpresa;
	}

	public String getWhatsApp() {
		return this.whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlLogo() {
		return this.urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getUrlBanner() {
		return this.urlBanner;
	}

	public void setUrlBanner(String urlBanner) {
		this.urlBanner = urlBanner;
	}

	public String getUrlLoja() {
		return this.urlLoja;
	}

	public void setUrlLoja(String urlLoja) {
		this.urlLoja = urlLoja;
	}
}