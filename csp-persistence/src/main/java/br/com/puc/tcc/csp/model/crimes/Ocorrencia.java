package br.com.puc.tcc.csp.model.crimes;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.locais.Logradouro;

@MappedSuperclass
public abstract class Ocorrencia extends Entidade {
	
	@Column(name="data_ocorrencia")
	private Timestamp dataOcorrencia;
	
	
	@Column(name="data_registro")
	private Timestamp dataRegistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_logradouro")
	@JsonIgnore
	private Logradouro localDoCrime;

	public Timestamp getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Timestamp dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public Timestamp getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Timestamp dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Logradouro getLocalDoCrime() {
		return localDoCrime;
	}

	public void setLocalDoCrime(Logradouro localDoCrime) {
		this.localDoCrime = localDoCrime;
	}
	
}
