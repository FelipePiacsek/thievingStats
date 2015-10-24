package br.com.puc.tcc.csp.model.locais;

import javax.persistence.MappedSuperclass;

import br.com.puc.tcc.csp.model.Entidade;

@MappedSuperclass
public abstract class Local extends Entidade{

	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
