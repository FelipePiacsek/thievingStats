package br.com.puc.tcc.csp.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.puc.tcc.csp.base.Container;
import br.com.puc.tcc.csp.model.Usuario;

@Stateless
@LocalBean
@Path("/usuario/")
public class UsuarioResource {

	@Inject
	private UsuarioService service;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLogradouroByCep(Usuario usuario) {
		List<ErrosValidacaoUsuario> errosNoCadastro = service.cadastrar(usuario);
		if(errosNoCadastro.isEmpty()){
			return Response.ok().build();
		}else{
			List<String> mensagens = new ArrayList<String>();
			for (ErrosValidacaoUsuario erro : errosNoCadastro) {
				mensagens.add(erro.getMensagemDeErro());
			}
			Container<List<String>> container = new Container<List<String>>(mensagens);
			return Response.status(400).entity(container).build();
		}
	}

}
