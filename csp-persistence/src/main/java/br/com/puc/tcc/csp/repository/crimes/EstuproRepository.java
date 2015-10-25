package br.com.puc.tcc.csp.repository.crimes;

import br.com.puc.tcc.csp.model.crimes.Estupro;

public class EstuproRepository extends AbstractCriminalidadeRepository<Estupro> {

	@Override
	protected Class<Estupro> getEntityType() {
		return Estupro.class;
	}

}
