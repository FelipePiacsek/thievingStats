package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import br.com.puc.tcc.csp.model.crimes.IndiceCriminalidade;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

public interface ICriminalidade {

	public IndiceCriminalidade calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias);
	
	default Double mediaAritmeticaPenas(Double penaMinima, Double penaMaxima){
		return (penaMinima+penaMaxima) / 2.0;
	}
	
}
