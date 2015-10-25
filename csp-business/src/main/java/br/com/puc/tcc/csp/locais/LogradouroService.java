package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.criminalidade.HistoricoCriminalService;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.repository.locais.LogradouroRepository;

/**
 * Classe de negócios referente aos logradouros.
 */
@Stateless
@LocalBean
public class LogradouroService implements ILocalService{

	@Inject
	private LogradouroRepository repository;
	
	@Inject 
	private HistoricoCriminalService historicoCriminalService;
	
	public List<Logradouro> getAll(){
		return repository.fetchAll();
	}

	public Logradouro getLogradouroByCep(String cep) {
		return repository.fetchLogradouroByCep(cep);
	}

	public Logradouro getLogradouroById(Long id) {
		return repository.fetchCompleteById(id);
	}

	@Override
	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		Logradouro logradouro = repository.fetchCompleteById(id);
		return historicoCriminalService.getHistoricoCriminal(logradouro, dataInicio, dataFim);
	}

}
