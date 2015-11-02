package br.com.puc.tcc.csp.comunicacao;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

import br.com.puc.tcc.csp.ConfiguracaoService;
import br.com.puc.tcc.csp.ConfiguracaoService.Configuracoes;
import br.com.puc.tcc.csp.model.Relatorio;
import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;

@Stateless
@LocalBean
public class EmailService {

	@Inject
	private ConfiguracaoService configuracoes;
	
	public void enviarRelatorio(Relatorio relatorio, Usuario usuario){
		
		String destinatario = usuario.getEmail();
		if(destinatario.endsWith("teste.da.massa")){
			teste(relatorio, usuario);
		}else{
			SendGrid.Email email = new SendGrid.Email();
			email.addTo(destinatario);
			email.setFrom(configuracoes.getValor(Configuracoes.REMETENTE));
			email.setSubject(assuntoEmail(relatorio.getDataInicio()));
			email.setText(corpoEmail(relatorio, usuario));
			try {
				new SendGrid(configuracoes.getValor(Configuracoes.SENDGRID_API)).send(email);
			} catch (SendGridException e) {
				
			}	
		}
	}

	private void teste(Relatorio relatorio, Usuario usuario){
		String destinatario = usuario.getEmail();
		String remetente = configuracoes.getValor(Configuracoes.REMETENTE);
		String assunto = assuntoEmail(relatorio.getDataInicio());
		String texto = corpoEmail(relatorio, usuario);
		
		System.out.println("Destinatário: " + destinatario);
		System.out.println("Remetente: " + remetente);
		System.out.println("Assunto: " + assunto);
		System.out.println("Texto: " + texto);
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
		
		sb.append(getTextoFromHistorico(relatorio.getHistoricoCidade(), "Cidade"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoZona(), "Zona"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoBairro(), "Bairro"));
		sb.append("\n\n");
		sb.append(getTextoFromHistorico(relatorio.getHistoricoLogradouro(), "Logradouro"));
		
		
		sb.append("Incentivamos a divulgação destes dados para nos ajudar na campanha pela popularização dos dados abertos.");
		sb.append("\n\n");
		sb.append("Atenciosamente, \n");
		sb.append("\tCaroline e Felipe.");
		return sb.toString();
	}

	private String getTextoFromHistorico(HistoricoCriminal historico, String tipoLocal) {
		StringBuilder sb = new StringBuilder(tipoLocal);
		sb.append("\nNome: ");
		sb.append(historico.getLocal().getNome());
		sb.append(":\n");
		
		sb.append("Roubos: ");
		sb.append(historico.getRoubos());
		
		sb.append("Estupros: ");
		sb.append(historico.getEstupros());
		
		sb.append("Homídios: ");
		sb.append(historico.getHomicidios());
		
		sb.append("Lesões Corporais: ");
		sb.append(historico.getLesoes());
		
		sb.append("Índice de criminalidade: ");
		sb.append(historico.getIndiceCriminalidade());
		
		return sb.toString();
	}
}
