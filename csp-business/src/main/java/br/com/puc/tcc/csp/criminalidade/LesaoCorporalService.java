package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.LesaoCorporal;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

@Stateless
@LocalBean
public class LesaoCorporalService implements ICriminalidade {

	private static final Double penaMinima = 0.25;

	private static final Double penaMaxima = 12.0;

	private static final Double fatorLesaoGrave = 1.25;
	
	private static final Double fatorLesaoLeve = 0.75;

	@Override
	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		Integer quantidadeLesoesGraves = getQuantidadeLesoes(ocorrencias, LesaoCorporal.TipoLesao.GRAVE);
		Integer quantidadeLesoesLeves = getQuantidadeLesoes(ocorrencias, LesaoCorporal.TipoLesao.LEVE);
		
		Double indice = efetuarCalculoIndice(quantidadeLesoesGraves, quantidadeLesoesLeves);
		
		return indice;
	}

	private double efetuarCalculoIndice(Integer quantidadeLesoesGraves, Integer quantidadeLesoesLeves) {
		return (quantidadeLesoesGraves * fatorLesaoGrave + quantidadeLesoesLeves * fatorLesaoLeve) * mediaAritmeticaPenas(penaMinima, penaMaxima);
	}

	private Integer getQuantidadeLesoes(List<? extends Ocorrencia> ocorrencias, LesaoCorporal.TipoLesao tipoLesao) {
		Long quantidade = ocorrencias.stream().filter(lesao -> ((LesaoCorporal) lesao).getTipo().equals(tipoLesao)).count();
		return quantidade.intValue();
	}
}
