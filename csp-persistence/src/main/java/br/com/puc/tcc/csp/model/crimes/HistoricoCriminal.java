package br.com.puc.tcc.csp.model.crimes;

import java.sql.Timestamp;

import br.com.puc.tcc.csp.model.locais.Local;

public class HistoricoCriminal {

	private Timestamp dataInicio;

	private Timestamp dataFim;
	
	private Local local;
	
	private Double indiceCriminalidade;
	
	private Integer roubos;
	
	private Integer estupros;
	
	private Integer lesoes;
	
	private Integer homicidios;
	
	public Integer getRoubos() {
		return roubos;
	}
	
	public void setRoubos(Integer roubos) {
		this.roubos = roubos;
	}
	
	public Integer getEstupros() {
		return estupros;
	}
	
	public void setEstupros(Integer estupros) {
		this.estupros = estupros;
	}
	
	public Integer getLesoes() {
		return lesoes;
	}
	
	public void setLesoes(Integer lesoes) {
		this.lesoes = lesoes;
	}
	
	public Integer getHomicidios() {
		return homicidios;
	}
	
	public void setHomicidios(Integer homicidios) {
		this.homicidios = homicidios;
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Double getIndiceCriminalidade() {
		return indiceCriminalidade;
	}

	public void setIndiceCriminalidade(Double indiceCriminalidade) {
		this.indiceCriminalidade = indiceCriminalidade;
	}
}
