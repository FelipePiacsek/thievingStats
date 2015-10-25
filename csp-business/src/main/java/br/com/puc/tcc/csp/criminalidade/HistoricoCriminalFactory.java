package br.com.puc.tcc.csp.criminalidade;

import java.sql.Timestamp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
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
	
	
	
	public <T extends Local> HistoricoCriminal construirHistoricoLogradouro(Logradouro logradouro, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(logradouro);
		historico.setEstupros(estuproRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim));
		historico.setHomicidios(homicidioRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim));
		historico.setLesoes(lesaoCorporalRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim));
		historico.setRoubos(rouboRepository.getOcorrenciasByLogradouroEDatas(logradouro, dataInicio, dataFim));
		//TODO serviço de cálculo para o índice.
		historico.setIndiceCriminalidade(0.0);
		return historico;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoBairro(Bairro bairro, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(bairro);
		return null;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoZona(Zona zona, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(zona);
		return null;
	}

	public <T extends Local> HistoricoCriminal construirHistoricoCidade(Cidade cidade, Timestamp dataInicio, Timestamp dataFim) {
		HistoricoCriminal historico = new HistoricoCriminal();
		historico.setDataInicio(dataInicio);
		historico.setDataFim(dataFim);
		historico.setLocal(cidade);
		return null;
	}

}
