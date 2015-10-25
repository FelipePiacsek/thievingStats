package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.puc.tcc.csp.model.crimes.Homicidio;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;

@Stateless
@LocalBean
public class HomicidioService implements ICriminalidade {

	private static final Double penaMinima = 6.0;

	private static final Double penaMaxima = 30.0;
	
	private static final Double fatorHomicidioCulposo = 0.5;

	private static final Double fatorHomicidioPrivilegiado = 0.75;
	
	private static final Double fatorHomicidioSimples = 1.0;
	
	private static final Double fatorHomicidioQualificado = 1.75;
	
	@Override
	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		Integer quantidadeCulposos = getQuantidadeHomicidios(ocorrencias, Homicidio.Qualificacao.CULPOSO);
		Integer quantidadeQualificados = getQuantidadeHomicidios(ocorrencias, Homicidio.Qualificacao.QUALIFICADO);
		Integer quantidadePrivilegiados = getQuantidadeHomicidios(ocorrencias, Homicidio.Qualificacao.PRIVILEGIADO);
		Integer quantidadeSimples = getQuantidadeHomicidios(ocorrencias, Homicidio.Qualificacao.SIMPLES);
		
		Double indice = efetuarCalculoIndice(quantidadeCulposos, quantidadeQualificados, quantidadePrivilegiados, quantidadeSimples);
		
		return indice;
	}

	private double efetuarCalculoIndice(Integer quantidadeCulposos, Integer quantidadeQualificados, Integer quantidadePrivilegiados, Integer quantidadeSimples) {
		return (quantidadeCulposos      * fatorHomicidioCulposo + 
				quantidadeQualificados  * fatorHomicidioQualificado + 
				quantidadePrivilegiados * fatorHomicidioPrivilegiado + 
				quantidadeSimples       * fatorHomicidioSimples) * mediaAritimeticaPenas();
	}

	private Integer getQuantidadeHomicidios(List<? extends Ocorrencia> ocorrencias, Homicidio.Qualificacao qualificacao) {
		Long quantidade = ocorrencias.stream().filter(homicidio -> ((Homicidio) homicidio).getTipo().equals(qualificacao)).count();
		return quantidade.intValue();
	}

	private Double mediaAritimeticaPenas(){
		return (penaMinima + penaMaxima) / 2.0;
	}

}
