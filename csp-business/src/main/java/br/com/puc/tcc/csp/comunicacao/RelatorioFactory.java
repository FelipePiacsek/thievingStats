package br.com.puc.tcc.csp.comunicacao;

import java.sql.Timestamp;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.criminalidade.HistoricoCriminalService;
import br.com.puc.tcc.csp.model.Relatorio;
import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;

@Stateless
@LocalBean
public class RelatorioFactory {

	@Inject
	private HistoricoCriminalService historicoCriminalService;
	
	public Relatorio construirRelatorio(Usuario usuario, Timestamp dataInicio, Timestamp dataFim){
		Relatorio relatorio = new Relatorio();
		HistoricoCriminal historicoRua = historicoCriminalService.getHistoricoCriminal(usuario.getResidencia(), dataInicio, dataFim);
		HistoricoCriminal historicoBairro = historicoCriminalService.getHistoricoCriminal(usuario.getResidencia().getBairro(), dataInicio, dataFim);
		HistoricoCriminal historicoZona = historicoCriminalService.getHistoricoCriminal(usuario.getResidencia().getBairro().getZona(), dataInicio, dataFim);
		HistoricoCriminal historicoCidade = historicoCriminalService.getHistoricoCriminal(usuario.getResidencia().getBairro().getZona().getCidade(), dataInicio, dataFim);
		relatorio.setHistoricoLogradouro(historicoRua);
		relatorio.setHistoricoBairro(historicoBairro);
		relatorio.setHistoricoZona(historicoZona);
		relatorio.setHistoricoCidade(historicoCidade);
		return relatorio;
	}
}
