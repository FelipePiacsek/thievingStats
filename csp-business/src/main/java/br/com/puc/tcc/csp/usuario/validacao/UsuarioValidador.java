package br.com.puc.tcc.csp.usuario.validacao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.repository.UsuarioRepository;
import br.com.puc.tcc.csp.repository.locais.LogradouroRepository;

public class UsuarioValidador {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private LogradouroRepository logradouroRepository;

	public List<ErrosValidacaoUsuario> validarCadastro(Usuario usuario){
		ArrayList<ErrosValidacaoUsuario> erros = new ArrayList<ErrosValidacaoUsuario>();
		if(usuario.getEmail().equals("") || usuario.getNome().equals("") || usuario.getSobrenome().equals("") || usuario.getResidencia() == null || usuario.getResidencia().getCep().equals("")){
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
