package br.com.puc.tcc.csp.model.locais;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "tb_zonas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Zona extends Local{
	
	@Id
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	@JsonManagedReference
	private Set<Bairro> bairros;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	@JsonBackReference
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setBairros(Set<Bairro> bairros){
		this.bairros = bairros;
	}
	
	public Set<Bairro> getBairros(){
		return this.bairros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
