package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.repository.locais.CidadeRepository;

@Stateless
@LocalBean
public class CidadeService implements ILocalService{

	@Inject
	private CidadeRepository repository;
	
	@Override
	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		Cidade cidade = null;
		return null;
	}
}
