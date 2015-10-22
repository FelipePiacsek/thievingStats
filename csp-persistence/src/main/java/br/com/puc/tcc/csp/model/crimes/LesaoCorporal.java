package br.com.puc.tcc.csp.model.crimes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name="tb_lesoes_corporais")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LesaoCorporal extends Ocorrencia{

	public enum TipoLesao{
		LEVE, GRAVE;
	}
	
	@Column(name="tipo_lesao")
	@Enumerated(EnumType.STRING)
	private TipoLesao tipo;

	public TipoLesao getTipo() {
		return tipo;
	}

	public void setTipo(TipoLesao tipo) {
		this.tipo = tipo;
	}
}
