package br.com.puc.tcc.csp.model.crimes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_homicidios")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Homicidio extends Ocorrencia{

	public enum Qualificacao{
		CULPOSO, PRIVILEGIADO, SIMPLES, QUALIFICADO;
	}
	
	@Enumerated(EnumType.STRING)
	private Qualificacao qualificacao;

	public Qualificacao getTipo() {
		return qualificacao;
	}

	public void setTipo(Qualificacao tipo) {
		this.qualificacao = tipo;
	}
	
}
