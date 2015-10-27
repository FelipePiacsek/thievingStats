package br.com.puc.tcc.csp.model.locais;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_logradouros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logradouro extends Local{

	private String cep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tipo_logradouro")
	private TipoLogradouro tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bairro")
	private Bairro bairro;

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public TipoLogradouro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogradouro tipo) {
		this.tipo = tipo;
	}

}
