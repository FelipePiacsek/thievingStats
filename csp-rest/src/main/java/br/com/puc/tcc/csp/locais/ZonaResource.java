package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

import br.com.puc.tcc.csp.base.AbstractLocalResource;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Zona;

@Path("/zona")
@Stateless
public class ZonaResource extends AbstractLocalResource<Zona>{

	@Inject
	private ZonaService service;

	@Override
	protected List<Zona> listAll() {
		return service.getAll();
	}

	@Override
	protected Zona getEntidadeById(Long id) {
		return service.getZonaById(id);
	}

	@Override
	protected HistoricoCriminal getHistoricoDoLocal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		return service.getHistoricoCriminal(id, dataInicio, dataFim);
	}

}
