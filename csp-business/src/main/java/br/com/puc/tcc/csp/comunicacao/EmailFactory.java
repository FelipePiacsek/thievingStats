package br.com.puc.tcc.csp.comunicacao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collections;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.text.WordUtils;

import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage.Recipient;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;

import br.com.puc.tcc.csp.ConfiguracaoService;
import br.com.puc.tcc.csp.ConfiguracaoService.Configuracoes;
import br.com.puc.tcc.csp.model.Relatorio;
import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;

@Stateless
@LocalBean
public class EmailFactory {

	@Inject
	private ConfiguracaoService configuracoes;
	
	public Email construirEmailSendGrid(Relatorio relatorio, Usuario usuario) {
		String destinatario = usuario.getEmail();
		SendGrid.Email email = new SendGrid.Email();
		email.addTo(destinatario);
		email.setFrom(configuracoes.getValor(Configuracoes.REMETENTE));
		email.setSubject(assuntoEmail(relatorio.getDataInicio()));
		email.setText(corpoEmail(relatorio, usuario));
		return email;
	}

	public MandrillMessage construirEmailMandrill(Relatorio relatorio, Usuario usuario){
		String destinatario = usuario.getEmail();
		MandrillMessage email = new MandrillMessage();
		Recipient r = new Recipient();
		r.setEmail(destinatario);
		email.setFromEmail(configuracoes.getValor(Configuracoes.REMETENTE));
		email.setSubject(assuntoEmail(relatorio.getDataInicio()));
		email.setTo(Collections.singletonList(r));
		email.setText(corpoEmail(relatorio, usuario));
		return email;
	}
	
	private String assuntoEmail(Timestamp dataInicio) {
		StringBuilder sb = new StringBuilder("Relatório de criminalidade ");
		LocalDate l = dataInicio.toLocalDateTime().toLocalDate();
		sb.append(l.getMonth().getValue());
		sb.append("/");
		sb.append(l.getYear());
		sb.append(".");
		return sb.toString();
	}

	private String corpoEmail(Relatorio relatorio, Usuario usuario) {
		StringBuilder sb = new StringBuilder("Olá, ");
		sb.append(usuario.getNome());
		sb.append("!");
		sb.append("\n\n\n");
		sb.append("Estes são os dados criminais relativos ao mês anterior(");
		sb.append(relatorio.getDataInicio().toLocalDateTime().getMonthValue());
		sb.append("/");
		sb.append(relatorio.getDataInicio().toLocalDateTime().getYear());
		sb.append("):\n\n");

		sb.append(getTextoFromHistorico(relatorio.getHistoricoLogradouro(), "Logradouro"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoBairro(), "Bairro"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoZona(), "Zona"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoCidade(), "Cidade"));

		sb.append(
				"\n\nIncentivamos a divulgação destes dados para nos ajudar na campanha pela popularização dos dados abertos.");
		sb.append("\n\n\n\n\n\n\n");
		sb.append("Atenciosamente, \n");
		sb.append("\tCaroline e Felipe.");
		return sb.toString();
	}

	private String getTextoFromHistorico(HistoricoCriminal historico, String tipoLocal) {
		StringBuilder sb = new StringBuilder(tipoLocal);
		sb.append(": ");
		sb.append(WordUtils.capitalizeFully(historico.getLocal().getNome()));

		sb.append("\nRoubos: ");
		sb.append(historico.getRoubos());

		sb.append("\nEstupros: ");
		sb.append(historico.getEstupros());

		sb.append("\nHomicídios: ");
		sb.append(historico.getHomicidios());

		sb.append("\nLesões Corporais: ");
		sb.append(historico.getLesoes());

		sb.append("\nÍndice de criminalidade: ");
		sb.append(historico.getIndiceCriminalidade());

		return sb.toString();
	}
}
