package br.com.puc.tcc.csp.comunicacao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.microtripit.mandrillapp.lutung.view.MandrillMessage;

import br.com.puc.tcc.csp.TimestampUtils;
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
	private RelatorioFactory relatorioFactory;
	
	@Inject
	private EmailFactory emailFactory;
	
	public void notificar(String emailUsuario){
		Usuario usuario = usuarioRepository.fetchCompleteByEmail(emailUsuario);
		Relatorio relatorio = relatorioFactory.construirRelatorio(usuario, TimestampUtils.primeiroDiaMesPassado(), TimestampUtils.ultimoDiaMesPassado());
		MandrillMessage email = emailFactory.construirEmailMandrill(relatorio, usuario);
		emailService.enviarEmail(email);
	}
	
	@Schedule(dayOfMonth = "7")
	private void notificarTodos(){
		List<Usuario> usuarios = usuarioRepository.fetchAll();
		for (Usuario usuario : usuarios) {
			Relatorio relatorio = relatorioFactory.construirRelatorio(usuario, TimestampUtils.primeiroDiaMesPassado(), TimestampUtils.ultimoDiaMesPassado());
			MandrillMessage email = emailFactory.construirEmailMandrill(relatorio, usuario);
			emailService.enviarEmail(email);
		}
	}
}
