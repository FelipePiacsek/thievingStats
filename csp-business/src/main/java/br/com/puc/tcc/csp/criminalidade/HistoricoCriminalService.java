package br.com.puc.tcc.csp.criminalidade;

import java.sql.Timestamp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.model.locais.Local;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Zona;

@Stateless
@LocalBean
public class HistoricoCriminalService {

	@Inject
	private HistoricoCriminalFactory factory;
	
	public <T extends Local> HistoricoCriminal getHistoricoCriminal(T local, Timestamp dataInicio, Timestamp dataFim){
		HistoricoCriminal historico = null;
		if(local instanceof Cidade){
			historico = factory.construirHistoricoCidade((Cidade)local, dataInicio, dataFim);
		}else if(local instanceof Zona){
			historico = factory.construirHistoricoZona((Zona)local, dataInicio, dataFim);
		}else if(local instanceof Bairro){
			historico = factory.construirHistoricoBairro((Bairro)local, dataInicio, dataFim);
		}else if(local instanceof Logradouro){
			historico = factory.construirHistoricoLogradouro((Logradouro)local, dataInicio, dataFim);
		}
		return historico;
	}


}
