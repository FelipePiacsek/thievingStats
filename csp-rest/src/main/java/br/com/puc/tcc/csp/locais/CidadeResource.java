package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

import br.com.puc.tcc.csp.base.AbstractLocalResource;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Cidade;

@Path("/cidade")
@Stateless
public class CidadeResource extends AbstractLocalResource<Cidade>{

	@Inject
	private CidadeService service;

	@Override
	protected List<Cidade> listAll() {
		return service.getAll();
	}

	@Override
	protected Cidade getEntidadeById(Long id) {
		return service.getCidadeById(id);
	}

	@Override
	protected HistoricoCriminal getHistoricoDoLocal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		return service.getHistoricoCriminal(id, dataInicio, dataFim);
	}

}
