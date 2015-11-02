package br.com.puc.tcc.csp.comunicacao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.Relatorio;
import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.repository.UsuarioRepository;

@Stateless
@LocalBean
public class NotificacaoService {
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private EmailService emailService;
	
	@Inject
	private RelatorioFactory relatorioService;
	
	public void notificar(String emailUsuario){
		Usuario usuario = usuarioRepository.fetchCompleteByEmail(emailUsuario);
		Relatorio relatorio = relatorioService.construirRelatorio(usuario, TimestampUtils.primeiroDiaMesPassado(), TimestampUtils.ultimoDiaMesPassado());
		emailService.enviarRelatorio(relatorio, usuario);
	}
	
	//Scheduler: uma vez por mês.
	private void notificarTodos(){
		List<Usuario> usuarios = usuarioRepository.fetchAll();
		for (Usuario usuario : usuarios) {
			Relatorio relatorio = relatorioService.construirRelatorio(usuario, TimestampUtils.primeiroDiaMesPassado(), TimestampUtils.ultimoDiaMesPassado());
			emailService.enviarRelatorio(relatorio, usuario);
		}
	}
}
