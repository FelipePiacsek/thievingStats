package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.repository.locais.ZonaRepository;

@Stateless
@LocalBean
public class ZonaService implements ILocalService {

	@Inject
	private ZonaRepository repository;
	
	@Override
	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		Zona zona = repository.fetchCompleteById(id);
		return null;
	}

}
