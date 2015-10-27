package br.com.puc.tcc.csp.model.locais;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import br.com.puc.tcc.csp.model.Entidade;

@MappedSuperclass
public abstract class Local extends Entidade{

	@Id
	private Long id;
	
	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
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
