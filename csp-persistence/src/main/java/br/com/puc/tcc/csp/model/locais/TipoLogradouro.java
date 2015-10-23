package br.com.puc.tcc.csp.model.locais;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tipos_logradouros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoLogradouro {

	@Id
	@JsonIgnore
	private Long id;
	
	@JsonIgnore
	private String sigla;
	
	private String descricao;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
