package br.com.puc.tcc.csp.model.crimes;

import java.sql.Timestamp;
import java.util.Collection;

import br.com.puc.tcc.csp.model.locais.Local;

public class HistoricoCriminal {

	private Timestamp dataInicio;

	private Timestamp dataFim;
	
	private Local local;
	
	private Double indiceCriminalidade;
	
	private Collection<Roubo> roubos;
	
	private Collection<Estupro> estupros;
	
	private Collection<LesaoCorporal> lesoes;
	
	private Collection<Homicidio> homicidios;
	
	public Collection<Roubo> getRoubos() {
		return roubos;
	}
	
	public void setRoubos(Collection<Roubo> roubos) {
		this.roubos = roubos;
	}
	
	public Collection<Estupro> getEstupros() {
		return estupros;
	}
	
	public void setEstupros(Collection<Estupro> estupros) {
		this.estupros = estupros;
	}
	
	public Collection<LesaoCorporal> getLesoes() {
		return lesoes;
	}
	
	public void setLesoes(Collection<LesaoCorporal> lesoes) {
		this.lesoes = lesoes;
	}
	
	public Collection<Homicidio> getHomicidios() {
		return homicidios;
	}
	
	public void setHomicidios(Collection<Homicidio> homicidios) {
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
