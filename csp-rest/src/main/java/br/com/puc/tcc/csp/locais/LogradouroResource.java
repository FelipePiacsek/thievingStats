package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;
import java.util.Collection;

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
import br.com.puc.tcc.csp.model.locais.Logradouro;

@Path("/logradouro")
@Stateless
public class LogradouroResource extends AbstractLocalResource<Logradouro>{

	@Inject
	private LogradouroService service;

	@GET
	@Path("cep/{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogradouroByCep(@PathParam("cep") String cep) {
		Logradouro logradouro = service.getLogradouroByCep(cep);
		Container<Logradouro> container = new Container<Logradouro>(logradouro);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}

	@Override
	protected Collection<Logradouro> listAll() {
		return service.getAll();
	}

	@Override
	protected Logradouro getEntidadeById(Long id) {
		return service.getLogradouroById(id);
	}

	@Override
	protected HistoricoCriminal getHistoricoDoLocal(Long id, Timestamp dataInicio, Timestamp dataFim) {
		return service.getHistoricoCriminal(id, dataInicio, dataFim);
	}

}
