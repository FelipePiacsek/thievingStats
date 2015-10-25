package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

public interface ICriminalidade {

	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias);
	
}
