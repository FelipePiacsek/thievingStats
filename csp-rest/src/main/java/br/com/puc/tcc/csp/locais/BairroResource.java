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
import br.com.puc.tcc.csp.model.locais.Bairro;

@Path("/bairro")
@Stateless
public class BairroResource {

	@Inject
	private BairroService service;

	@GET
	@Path("all/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Bairro> bairros = service.getAll();
		Container<Bairro> container = new Container<Bairro>(bairros);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}
	
	@GET
	@Path("{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBairroById(@PathParam("id") final Long id){
		Bairro bairro = service.geBairroById(id);
		Container<Bairro> container = new Container<Bairro>(bairro);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}
}
