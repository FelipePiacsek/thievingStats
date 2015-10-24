package br.com.puc.tcc.csp.model.crimes;

import java.sql.Timestamp;
import java.util.Set;

import br.com.puc.tcc.csp.model.locais.Local;

public class HistoricoCriminal<T extends Local> {

	private Timestamp dataInicio;

	private Timestamp dataFim;
	
	private T local;
	
	private Double indiceCriminalidade;
	
	private Set<Roubo> roubos;
	
	private Set<Estupro> estupros;
	
	private Set<LesaoCorporal> lesoes;
	
	private Set<Homicidio> homicidios;
	
	public Set<Roubo> getRoubos() {
		return roubos;
	}
	
	public void setRoubos(Set<Roubo> roubos) {
		this.roubos = roubos;
	}
	
	public Set<Estupro> getEstupros() {
		return estupros;
	}
	
	public void setEstupros(Set<Estupro> estupros) {
		this.estupros = estupros;
	}
	
	public Set<LesaoCorporal> getLesoes() {
		return lesoes;
	}
	
	public void setLesoes(Set<LesaoCorporal> lesoes) {
		this.lesoes = lesoes;
	}
	
	public Set<Homicidio> getHomicidios() {
		return homicidios;
	}
	
	public void setHomicidios(Set<Homicidio> homicidios) {
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

	public void setLocal(T local) {
		this.local = local;
	}

	public Double getIndiceCriminalidade() {
		return indiceCriminalidade;
	}

	public void setIndiceCriminalidade(Double indiceCriminalidade) {
		this.indiceCriminalidade = indiceCriminalidade;
	}
}
