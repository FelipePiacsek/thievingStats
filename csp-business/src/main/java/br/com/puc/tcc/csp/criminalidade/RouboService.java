package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

@Stateless
@LocalBean
public class RouboService implements ICriminalidade {

	private static final Double penaMinima = 6.0;

	private static final Double penaMaxima = 10.0;
	
	@Override
	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		Integer quantidadeDeRoubos = ocorrencias.size();
		
		Double indice = efetuarCalculoIndice(quantidadeDeRoubos);
		
		return indice;
	}

	private Double efetuarCalculoIndice(Integer quantidadeDeRoubos) {
		return quantidadeDeRoubos * mediaAritimeticaPenas();
	}
	
	private Double mediaAritimeticaPenas(){
		return (penaMinima + penaMaxima) / 2.0;
	}

}
