package br.com.puc.tcc.csp.model.locais;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_bairros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bairro extends Local {

	@Id
	private Long id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bairro")
	@JsonIgnore
	private Set<Logradouro> logradouros;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	private Zona zona;

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Set<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(Set<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
