package br.com.puc.tcc.csp.model.crimes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_roubos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roubo extends Ocorrencia{

	@Column(name = "mao_armada")
	private Boolean maoArmada;
	
	@Column(name = "somatoria_roubada")
	private Double somatoriaRoubada;

	public Boolean isMaoArmada() {
		return maoArmada;
	}

	public void setMaoArmada(Boolean maoArmada) {
		this.maoArmada = maoArmada;
	}

	public Double getSomatoriaRoubada() {
		return somatoriaRoubada;
	}

	public void setSomatoriaRoubada(Double somatoriaRoubada) {
		this.somatoriaRoubada = somatoriaRoubada;
	}
}
