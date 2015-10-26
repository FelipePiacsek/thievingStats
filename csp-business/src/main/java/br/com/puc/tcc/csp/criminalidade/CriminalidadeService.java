package br.com.puc.tcc.csp.criminalidade;

import java.util.List;

import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.Estupro;
import br.com.puc.tcc.csp.model.crimes.Homicidio;
import br.com.puc.tcc.csp.model.crimes.LesaoCorporal;
import br.com.puc.tcc.csp.model.crimes.Roubo;

public class CriminalidadeService{

	@Inject
	private RouboService rouboService;

	@Inject
	private EstuproService estuproService;

	@Inject
	private LesaoCorporalService lesaoCorporalService;

	@Inject
	private HomicidioService homicidioService;
	
	public Double calcularIndiceRoubos(List<Roubo> roubos){
		return rouboService.calcularIndiceCriminalidade(roubos);
	}
	
	public Double calcularIndiceEstupros(List<Estupro> estupros){
		return estuproService.calcularIndiceCriminalidade(estupros);
	}
	
	public Double calcularIndiceHomicidios(List<Homicidio> homicidios){
		return homicidioService.calcularIndiceCriminalidade(homicidios);
	}
	
	public Double calcularIndiceLesoesCorporais(List<LesaoCorporal> lesoes){
		return lesaoCorporalService.calcularIndiceCriminalidade(lesoes);
	}

}
