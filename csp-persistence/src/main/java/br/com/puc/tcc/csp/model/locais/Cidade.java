package br.com.puc.tcc.csp.model.locais;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@Table(name = "tb_cidades")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidade extends Local{

	@OneToMany(fetch = FetchType.LAZY, mappedBy="cidade")
	private Set<Zona> zonas;

	public Set<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(Set<Zona> zonas) {
		this.zonas = zonas;
	}
	
}
