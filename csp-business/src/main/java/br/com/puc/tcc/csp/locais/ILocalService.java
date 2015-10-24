package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;
import br.com.puc.tcc.csp.model.locais.Local;

public interface ILocalService<T extends Local> {

	public HistoricoCriminal<T> getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim);
}
