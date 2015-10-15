package br.com.puc.tcc.csp.locais.model;

import static javax.persistence.FetchType.EAGER;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "tb_bairros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bairro {
	
	@Id
	private Long id;

	private String nome;
	
	@OneToMany(fetch = EAGER)
	@JoinColumn(name = "id_bairro")
	@JsonManagedReference
	private Set<Logradouro> logradouros;

	public Set<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(Set<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
