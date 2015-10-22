package br.com.puc.tcc.csp.model.locais;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
@Entity
@Table(name = "tb_cidades")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidade extends Local{

	@Id
	private Long id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	@JsonManagedReference
	private Set<Zona> zonas;

	public Set<Zona> getZonas() {
		return zonas;
	}

	public void setZonas(Set<Zona> zonas) {
		this.zonas = zonas;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
