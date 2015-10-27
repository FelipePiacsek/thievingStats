package br.com.puc.tcc.csp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import br.com.puc.tcc.csp.model.locais.Logradouro;

@Entity
@Table(name = "tb_usuarios")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario extends Entidade{
	
	@Id
    @SequenceGenerator(allocationSize = 0, name = "tb_usuarios_id_seq", sequenceName = "tb_usuarios_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuarios_id_seq")
	private Long id;

	private String nome;
	
	private String sobrenome;
	
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_logradouro")
	private Logradouro residencia;

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

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
