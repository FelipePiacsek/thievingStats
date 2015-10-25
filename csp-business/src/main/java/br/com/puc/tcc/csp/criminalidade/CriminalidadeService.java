package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.Estupro;
import br.com.puc.tcc.csp.model.crimes.Homicidio;
import br.com.puc.tcc.csp.model.crimes.LesaoCorporal;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;
import br.com.puc.tcc.csp.model.crimes.Roubo;

public class CriminalidadeService implements ICriminalidade {

	@Inject
	private RouboService rouboService;

	@Inject
	private EstuproService estuproService;

	@Inject
	private LesaoCorporalService lesaoCorporalService;

	@Inject
	private HomicidioService homicidioService;

	@Override
	public Double calcularIndiceCriminalidade(List<? extends Ocorrencia> ocorrencias) {
		Double indiceCriminalidade = null;
		if (ocorrencias.size() > 0) {
			Ocorrencia ocorrencia = ocorrencias.stream().findFirst().get();
			if (ocorrencia instanceof Roubo) {
				indiceCriminalidade = rouboService.calcularIndiceCriminalidade(ocorrencias);
			} else if (ocorrencia instanceof LesaoCorporal) {
				indiceCriminalidade = lesaoCorporalService.calcularIndiceCriminalidade(ocorrencias);
			} else if (ocorrencia instanceof Homicidio) {
				indiceCriminalidade = homicidioService.calcularIndiceCriminalidade(ocorrencias);
			} else if (ocorrencia instanceof Estupro) {
				indiceCriminalidade = estuproService.calcularIndiceCriminalidade(ocorrencias);
			}
		}
		return indiceCriminalidade;
	}

}
