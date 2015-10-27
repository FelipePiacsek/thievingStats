package br.com.puc.tcc.csp.usuario;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.repository.UsuarioRepository;
import br.com.puc.tcc.csp.repository.locais.LogradouroRepository;

/**
 * Classe de negócios referente aos usuários.
 */
@Stateless
@LocalBean
public class UsuarioService {

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private LogradouroRepository logradouroRepository;
	
	@Inject
	private UsuarioValidador validador;
	
	public List<ErrosValidacaoUsuario> cadastrar(Usuario usuario) {
		List<ErrosValidacaoUsuario> erros = validador.validarCadastro(usuario);
		if(erros.isEmpty()){
			usuario.setResidencia(logradouroRepository.fetchLogradouroByCep(usuario.getResidencia().getCep()));
			usuarioRepository.save(usuario);
		}
		return erros;
	}
}
