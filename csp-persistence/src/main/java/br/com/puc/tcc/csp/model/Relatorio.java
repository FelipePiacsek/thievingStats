package br.com.puc.tcc.csp.model;

import java.sql.Timestamp;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;

public class Relatorio {

	private Timestamp dataInicio; 

	private Timestamp dataFim; 
	
	private HistoricoCriminal historicoLogradouro;

	private HistoricoCriminal historicoBairro;
	
	private HistoricoCriminal historicoZona;
	
	private HistoricoCriminal historicoCidade;

	public HistoricoCriminal getHistoricoLogradouro() {
		return historicoLogradouro;
	}

	public void setHistoricoLogradouro(HistoricoCriminal historicoLogradouro) {
		this.historicoLogradouro = historicoLogradouro;
	}

	public HistoricoCriminal getHistoricoBairro() {
		return historicoBairro;
	}

	public void setHistoricoBairro(HistoricoCriminal historicoBairro) {
		this.historicoBairro = historicoBairro;
	}

	public HistoricoCriminal getHistoricoZona() {
		return historicoZona;
	}

	public void setHistoricoZona(HistoricoCriminal historicoZona) {
		this.historicoZona = historicoZona;
	}

	public HistoricoCriminal getHistoricoCidade() {
		return historicoCidade;
	}

	public void setHistoricoCidade(HistoricoCriminal historicoCidade) {
		this.historicoCidade = historicoCidade;
	}

	public Timestamp getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Timestamp getDataFim() {
		return dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
}
