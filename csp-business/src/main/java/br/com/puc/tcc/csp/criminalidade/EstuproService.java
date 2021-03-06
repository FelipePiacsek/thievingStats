package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.Estupro;
import br.com.puc.tcc.csp.model.crimes.IndiceCriminalidade;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

@Stateless
@LocalBean
public class EstuproService implements ICriminalidade {

	private static final Double penaMinima = 6.0;

	private static final Double penaMaxima = 10.0;
	
	private static final Double fatorMaximoIdade = 1.75;
	
	@Override
	public IndiceCriminalidade calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		IndiceCriminalidade indice = efetuarCalculoIndice(ocorrencias);
		
		return indice;
	}

	private IndiceCriminalidade efetuarCalculoIndice(List<? extends Ocorrencia> ocorrencias) {
		Double fatorMediaDeIdadeVitimas = calcularFatorMediaDeIdade(ocorrencias);
		Integer quantidadeDeEstupros = ocorrencias.size();
		IndiceCriminalidade indice = new IndiceCriminalidade();
		indice.setValor(quantidadeDeEstupros * mediaAritmeticaPenas(penaMinima, penaMaxima) * fatorMediaDeIdadeVitimas);
		return indice;
	}

	private Double calcularFatorMediaDeIdade(List<? extends Ocorrencia> ocorrencias) {
		Double mediaDeIdade = 0.0;
		for (Ocorrencia ocorrencia : ocorrencias) {
			mediaDeIdade += ((Estupro) ocorrencia).getIdadeVitima();
		}
		mediaDeIdade = mediaDeIdade / ocorrencias.size();
		
		return fatorMaximoIdade - (mediaDeIdade / 100.0);
	}
	
}
