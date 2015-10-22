package br.com.puc.tcc.csp.locais;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.puc.tcc.csp.base.Container;
import br.com.puc.tcc.csp.model.locais.Logradouro;

@Path("/logradouro")
@Stateless
public class LogradouroResource {

	@Inject
	private LogradouroService service;

	@GET
	@Path("all/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Logradouro> logradouros = service.getAll();
		Container<Logradouro> container = new Container<Logradouro>(logradouros);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}
	
	@GET
	@Path("{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogradouroByCep(@PathParam("cep") String cep) {
		Logradouro logradouro = service.getLogradouro(cep);
		Container<Logradouro> container = new Container<Logradouro>(logradouro);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}
}
