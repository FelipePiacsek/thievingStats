package br.com.puc.tcc.csp.model.locais;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_zonas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Zona extends Local{
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona")
	@JsonIgnore
	private Set<Bairro> bairros;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cidade")
	@JsonIgnore
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

}
