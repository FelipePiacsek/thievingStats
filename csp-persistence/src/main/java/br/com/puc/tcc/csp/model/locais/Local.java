package br.com.puc.tcc.csp.model.locais;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Local {

	private String nome;
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
