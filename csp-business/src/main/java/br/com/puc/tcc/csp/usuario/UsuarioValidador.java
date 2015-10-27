package br.com.puc.tcc.csp.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.repository.UsuarioRepository;
import br.com.puc.tcc.csp.repository.locais.LogradouroRepository;

public class UsuarioValidador {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private LogradouroRepository logradouroRepository;

	public List<ErrosValidacaoUsuario> validarCadastro(Usuario usuario){
		ArrayList<ErrosValidacaoUsuario> erros = new ArrayList<ErrosValidacaoUsuario>();
		if(usuario.getEmail() == null || usuario.getNome() == null || usuario.getSobrenome() == null || usuario.getResidencia() == null || usuario.getResidencia().getCep() == null){
			erros.add(ErrosValidacaoUsuario.CADASTRO_INCOMPLETO);
		}else{
			if(usuarioRepository.existe(usuario)){
				erros.add(ErrosValidacaoUsuario.USUARIO_REPETIDO);
			}else{
				if(!logradouroRepository.existe(usuario.getResidencia().getCep())){
					erros.add(ErrosValidacaoUsuario.RESIDENCIA_NAO_ENCONTRADA);
				}
			}
		}
		return erros;
	}
	
}
