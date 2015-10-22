package br.com.puc.tcc.csp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;

import br.com.puc.tcc.csp.model.locais.Logradouro;

@Entity
@Table(name = "tb_usuarios")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

	@Id
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	@Email
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_logradouro")
	private Logradouro residencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Logradouro getResidencia() {
		return residencia;
	}

	public void setResidencia(Logradouro residencia) {
		this.residencia = residencia;
	}
	
	
}
