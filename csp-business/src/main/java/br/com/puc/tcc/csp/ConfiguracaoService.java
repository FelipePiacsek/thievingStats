package br.com.puc.tcc.csp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.Configuracao;
import br.com.puc.tcc.csp.repository.ConfiguracoesRepository;

@Stateless
@LocalBean
public class ConfiguracaoService {

	public enum Configuracoes{
		REMETENTE("EMAIL_REMETENTE"), SENDGRID_API("SENDGRID_API_KEY"), MANDRILL_API("MANDRILL_API_KEY");
		
		private String key;
		
		Configuracoes(String k){
			key = k;
		}
		
		public String getKey(){
			return this.key;
		}
	}
	
	@Inject
	private ConfiguracoesRepository repository;
	
	public String getValor(Configuracoes configuracoes){
		Configuracao configuracao = repository.fetchProperty(configuracoes.getKey());
		return configuracao.getValor();
	}
}
