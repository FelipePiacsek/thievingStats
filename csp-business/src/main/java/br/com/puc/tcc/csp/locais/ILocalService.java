package br.com.puc.tcc.csp.locais;

import java.sql.Timestamp;

import br.com.puc.tcc.csp.model.crimes.HistoricoCriminal;

public interface ILocalService {

	public HistoricoCriminal getHistoricoCriminal(Long id, Timestamp dataInicio, Timestamp dataFim);
}
