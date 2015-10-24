package br.com.puc.tcc.csp.base;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Local;

public abstract class AbstractLocalResource<T extends Local> extends AbstractResource<T>{


    @Context
    private UriInfo uriInfo;
    
	@GET
	@Path("all/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		Collection<T> entidades = listAll();
		Container<T> container = new Container<T>(entidades);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}
	
	@GET
	@Path("{id}/historicoCriminal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHistoricoCriminal(@PathParam("id") Long id){
		MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
		Timestamp dataInicio =  obterData("dataInicio", queryParameters);
		Timestamp dataFim =  obterData("dataFim", queryParameters);
		HistoricoCriminal<T> historico = getHistoricoDoLocal(id, dataInicio, dataFim);
		Container<HistoricoCriminal<T>> container = new Container<HistoricoCriminal<T>> (historico);
		ResponseBuilder buider = Response.ok().entity(container);
		return buider.build();
	}


	protected abstract Collection<T> listAll();
	
	protected abstract HistoricoCriminal<T> getHistoricoDoLocal(Long id, Timestamp dataInicio, Timestamp dataFim);

	private Timestamp obterData(String data, MultivaluedMap<String,String> queryParameters) {
		List<String> datas = queryParameters.get(data);
		if(datas.size() > 0){
			return Timestamp.valueOf(datas.get(0));
		}
		return null;
	}
}
