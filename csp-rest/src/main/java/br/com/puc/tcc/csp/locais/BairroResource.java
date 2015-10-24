package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.puc.tcc.csp.base.AbstractLocalResource;
import br.com.puc.tcc.csp.base.Container;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Logradouro;

@Path("/bairro")
@Stateless
public class BairroResource extends AbstractLocalResource<Bairro>{

	@Inject
	private BairroService service;
	
	@GET
	@Path("{id}/logradouros")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogradourosFromBairro(@PathParam("id") final Long id){
		Set<Logradouro> logradouros = service.getLogradourosFromBairro(id);
		Container<Logradouro> container = new Container<Logradouro>(logradouros);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}

	@Override
	protected Collection<Bairro> listAll() {
		return service.getAll();
	}

	@Override
	protected Bairro getEntidadeById(Long id) {
		return service.getBairroById(id);
	}

	@Override
	protected HistoricoCriminal<Bairro> getHistoricoDoLocal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		return service.getHistoricoCriminal(id, dataInicio, dataFim);
	}

}
