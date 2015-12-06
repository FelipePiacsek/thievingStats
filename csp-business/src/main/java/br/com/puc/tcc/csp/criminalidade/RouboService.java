package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.IndiceCriminalidade;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;
import br.com.puc.tcc.csp.model.crimes.Roubo;

@Stateless
@LocalBean
public class RouboService implements ICriminalidade {

	private static final Double penaMinima = 6.0;

	private static final Double penaMaxima = 10.0;
	
	private static final Double fatorMinimoMaoArmada = 1.0;
	
	@Override
	public IndiceCriminalidade calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		IndiceCriminalidade indice = efetuarCalculoIndice(ocorrencias);
		return indice;
	}

	private IndiceCriminalidade efetuarCalculoIndice(List<? extends Ocorrencia> ocorrencias) {
		Double fatorMaoArmada = calcularFatorMaoArmada(ocorrencias);
		IndiceCriminalidade indice = new IndiceCriminalidade();
		indice.setValor(ocorrencias.size() * mediaAritmeticaPenas(penaMinima, penaMaxima) * fatorMaoArmada);
		return indice;
	}

	private Double calcularFatorMaoArmada(List<? extends Ocorrencia> ocorrencias) {
		Long quantidadeMaoArmada = ocorrencias.stream().filter(roubo -> ((Roubo) roubo).isMaoArmada()).count();
		Double mediaMaoArmada =  (quantidadeMaoArmada.doubleValue() / ocorrencias.size());
		return fatorMinimoMaoArmada + mediaMaoArmada;
	}
	

}
