package br.com.puc.tcc.csp.base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public abstract class AbstractResource<T> {

	@GET
	@Path("{id}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") final Long id){
		T entidade = getEntidadeById(id);
		Container<T> container = new Container<T>(entidade);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}

	protected abstract T getEntidadeById(Long id);
}
