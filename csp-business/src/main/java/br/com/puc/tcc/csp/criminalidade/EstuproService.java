package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

@Stateless
@LocalBean
public class EstuproService implements ICriminalidade {

	private static final Double penaMinima = 6.0;

	private static final Double penaMaxima = 10.0;
	
	@Override
	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		Integer quantidadeDeEstupros = ocorrencias.size();
		
		Double indice = efetuarCalculoIndice(quantidadeDeEstupros);
		
		return indice;
	}

	private Double efetuarCalculoIndice(Integer quantidadeDeRoubos) {
		return quantidadeDeRoubos * mediaAritmeticaPenas(penaMinima, penaMaxima);
	}
	
}
