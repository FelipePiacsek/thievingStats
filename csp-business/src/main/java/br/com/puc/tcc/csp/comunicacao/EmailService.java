package br.com.puc.tcc.csp.comunicacao;

import java.io.IOException;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.microtripit.mandrillapp.lutung.MandrillApi;
import com.microtripit.mandrillapp.lutung.model.MandrillApiError;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

import br.com.puc.tcc.csp.ConfiguracaoService;
import br.com.puc.tcc.csp.ConfiguracaoService.Configuracoes;

@Stateless
@LocalBean
@Asynchronous
public class EmailService {

	@Inject
	private ConfiguracaoService configuracoes;
	
	/**
	 * Envia um e-mail utilizando SendGrid.
	 * @param email no formato SendGrid.
	 */
	public void enviarEmail(Email email){
		try {
			new SendGrid(configuracoes.getValor(Configuracoes.SENDGRID_API)).send(email);
			System.out.println("Email enviado para " + email.getTos()[0]);
		} catch (SendGridException e) {
			
		}	
	}
	
	/**
	 * Envia um e-mail utilizando MandrillApp.
	 * @param email no formato Mandrill.
	 */
	public void enviarEmail(MandrillMessage email){
		try {
			new MandrillApi(configuracoes.getValor(Configuracoes.MANDRILL_API)).messages().send(email, true);
			System.out.println("Email enviado para " + email.getTo().get(0).getEmail());
		} catch (MandrillApiError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
