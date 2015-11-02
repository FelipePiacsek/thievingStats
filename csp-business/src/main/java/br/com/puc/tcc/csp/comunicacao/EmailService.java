package br.com.puc.tcc.csp.comunicacao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

import br.com.puc.tcc.csp.ConfiguracaoService;
import br.com.puc.tcc.csp.ConfiguracaoService.Configuracoes;

@Stateless
@LocalBean
public class EmailService {

	@Inject
	private ConfiguracaoService configuracoes;

	
	public void enviarEmail(Email email){
		try {
			new SendGrid(configuracoes.getValor(Configuracoes.SENDGRID_API)).send(email);
			System.out.println("Email enviado para " + email.getTos()[0]);
		} catch (SendGridException e) {
			
		}	
	}

}
