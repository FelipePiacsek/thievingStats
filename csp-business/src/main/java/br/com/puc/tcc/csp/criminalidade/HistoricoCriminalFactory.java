package br.com.puc.tcc.csp.criminalidade;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.Estupro;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.crimes.Homicidio;
import br.com.puc.tcc.csp.model.crimes.LesaoCorporal;
import br.com.puc.tcc.csp.model.crimes.Roubo;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.model.locais.Local;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.repository.crimes.EstuproRepository;
import br.com.puc.tcc.csp.repository.crimes.HomicidioRepository;
import br.com.puc.tcc.csp.repository.crimes.LesaoCorporalRepository;
import br.com.puc.tcc.csp.repository.crimes.RouboRepository;

@Stateless
@LocalBean
public class HistoricoCriminalFactory {

	@Inject
	private RouboRepository rouboRepository;

	@Inject
	private EstuproRepository estuproRepository;

	@Inject
	private LesaoCorporalRepository lesaoCorporalRepository;

	@Inject
	private HomicidioRepository homicidioRepository;

	@Inject
	private CriminalidadeService criminalidadeService;

	public <T extends Local> HistoricoCriminal construirHistoricoLogradouro(Logradouro logradouro, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(logradouro);

		List<Estupro> estupros = estuproRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim);
		List<Homicidio> homicidios = homicidioRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim);
		List<LesaoCorporal> lesoes = lesaoCorporalRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim);
		List<Roubo> roubos = rouboRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim);

		historico.setEstupros(estupros.size());
		historico.setHomicidios(homicidios.size());
		historico.setLesoes(lesoes.size());
		historico.setRoubos(roubos.size());

		Double indice = getIndice(estupros, homicidios, lesoes, roubos);
		historico.setIndiceCriminalidade(indice);
		
		return historico;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoBairro(Bairro bairro, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(bairro);
		
		List<Estupro> estupros = estuproRepository.getOcorrenciasByBairroEDatas(bairro, dataInicio, dataFim);
		List<Homicidio> homicidios = homicidioRepository.getOcorrenciasByBairroEDatas(bairro, dataInicio, dataFim);
		List<LesaoCorporal> lesoes = lesaoCorporalRepository.getOcorrenciasByBairroEDatas(bairro, dataInicio, dataFim);
		List<Roubo> roubos = rouboRepository.getOcorrenciasByBairroEDatas(bairro, dataInicio, dataFim);
		
		historico.setEstupros(estupros.size());
		historico.setHomicidios(homicidios.size());
		historico.setLesoes(lesoes.size());
		historico.setRoubos(roubos.size());
		
		Double indice = getIndice(estupros, homicidios, lesoes, roubos);
		historico.setIndiceCriminalidade(indice);
		
		return historico;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoZona(Zona zona, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(zona);
		
		List<Estupro> estupros = estuproRepository.getOcorrenciasByZonaEDatas(zona, dataInicio, dataFim);
		List<Homicidio> homicidios = homicidioRepository.getOcorrenciasByZonaEDatas(zona, dataInicio, dataFim);
		List<LesaoCorporal> lesoes = lesaoCorporalRepository.getOcorrenciasByZonaEDatas(zona, dataInicio, dataFim);
		List<Roubo> roubos = rouboRepository.getOcorrenciasByZonaEDatas(zona, dataInicio, dataFim);
		
		historico.setEstupros(estupros.size());
		historico.setHomicidios(homicidios.size());
		historico.setLesoes(lesoes.size());
		historico.setRoubos(roubos.size());
		
		Double indice = getIndice(estupros, homicidios, lesoes, roubos);
		historico.setIndiceCriminalidade(indice);
		
		return historico;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoCidade(Cidade cidade, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(cidade);
		
		List<Estupro> estupros = estuproRepository.getOcorrenciasByCidadeEDatas(cidade, dataInicio, dataFim);
		List<Homicidio> homicidios = homicidioRepository.getOcorrenciasByCidadeEDatas(cidade, dataInicio, dataFim);
		List<LesaoCorporal> lesoes = lesaoCorporalRepository.getOcorrenciasByCidadeEDatas(cidade, dataInicio, dataFim);
		List<Roubo> roubos = rouboRepository.getOcorrenciasByCidadeEDatas(cidade, dataInicio, dataFim);
		
		historico.setEstupros(estupros.size());
		historico.setHomicidios(homicidios.size());
		historico.setLesoes(lesoes.size());
		historico.setRoubos(roubos.size());
		
		Double indice = getIndice(estupros, homicidios, lesoes, roubos);
		historico.setIndiceCriminalidade(indice);
		return historico;
	}

	private Double getIndice(List<Estupro> estupros, List<Homicidio> homicidios, List<LesaoCorporal> lesoes, List<Roubo> roubos) {
		Double iEstupros = criminalidadeService.calcularIndiceEstupros(estupros);
		Double iHomicidios = criminalidadeService.calcularIndiceHomicidios(homicidios);
		Double iLesoes = criminalidadeService.calcularIndiceLesoesCorporais(lesoes);
		Double iRoubos = criminalidadeService.calcularIndiceRoubos(roubos);
		return iEstupros + iHomicidios + iLesoes + iRoubos;
	}

}
