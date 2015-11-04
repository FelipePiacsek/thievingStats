package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.criminalidade.HistoricoCriminalService;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.repository.locais.ZonaRepository;

@Stateless
@LocalBean
public class ZonaService implements ILocalService {

	@Inject
	private ZonaRepository repository;
	
	@Inject
	private HistoricoCriminalService historicoCriminalService;
	
	@Override
	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		Zona zona = repository.fetchByIdWithCidade(id);
		return historicoCriminalService.getHistoricoCriminal(zona, dataInicio, dataFim);
	}

	public Zona getZonaById(Long id) {
		return repository.fetchCompleteById(id);
	}

	public List<Zona> getAll() {
		return repository.fetchAll();
	}

}
