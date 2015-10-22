package br.com.puc.tcc.csp.model.locais;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_logradouros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logradouro extends Local{

	@Id
	private Long id;
	
	private Integer cep;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_logradouro")
	private TipoLogradouro tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bairro")
	@JsonBackReference
	private Bairro bairro;

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public TipoLogradouro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogradouro tipo) {
		this.tipo = tipo;
	}

}
