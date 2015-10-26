package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.criminalidade.HistoricoCriminalService;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.repository.locais.CidadeRepository;

@Stateless
@LocalBean
public class CidadeService implements ILocalService {

	@Inject
	private CidadeRepository repository;

	@Inject
	private HistoricoCriminalService historicoCriminalService;

	@Override
	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		Cidade cidade = repository.fetchCompleteById(id);
		return historicoCriminalService.getHistoricoCriminal(cidade, dataInicio, dataFim);
	}

	public Cidade getCidadeById(Long id) {
		return repository.fetchById(id);
	}

	public List<Cidade> getAll() {
		return repository.fetchAll();
	}
}
