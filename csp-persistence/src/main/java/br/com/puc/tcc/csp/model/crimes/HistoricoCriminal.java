package br.com.puc.tcc.csp.model.crimes;

import java.sql.Timestamp;
import java.util.List;

import br.com.puc.tcc.csp.model.locais.Local;

public class HistoricoCriminal {

	private Timestamp dataInicio;

	private Timestamp dataFim;
	
	private Local local;
	
	private Double indiceCriminalidade;
	
	private List<Roubo> roubos;
	
	private List<Estupro> estupros;
	
	private List<LesaoCorporal> lesoes;
	
	private List<Homicidio> homicidios;
	
	public List<Roubo> getRoubos() {
		return roubos;
	}
	
	public void setRoubos(List<Roubo> roubos) {
		this.roubos = roubos;
	}
	
	public List<Estupro> getEstupros() {
		return estupros;
	}
	
	public void setEstupros(List<Estupro> estupros) {
		this.estupros = estupros;
	}
	
	public List<LesaoCorporal> getLesoes() {
		return lesoes;
	}
	
	public void setLesoes(List<LesaoCorporal> lesoes) {
		this.lesoes = lesoes;
	}
	
	public List<Homicidio> getHomicidios() {
		return homicidios;
	}
	
	public void setHomicidios(List<Homicidio> homicidios) {
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
