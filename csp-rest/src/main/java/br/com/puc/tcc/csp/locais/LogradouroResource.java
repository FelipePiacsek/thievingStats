package br.com.puc.tcc.csp.locais;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.puc.tcc.csp.locais.model.Logradouro;

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
        ResponseBuilder buider = Response.ok().entity(logradouros);
        return buider.build();
    }
}
