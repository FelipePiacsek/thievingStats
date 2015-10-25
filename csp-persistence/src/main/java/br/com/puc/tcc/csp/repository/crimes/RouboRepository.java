package br.com.puc.tcc.csp.repository.crimes;

import br.com.puc.tcc.csp.model.crimes.Roubo;

public class RouboRepository extends AbstractCriminalidadeRepository<Roubo> {

	@Override
	protected Class<Roubo> getEntityType() {
		return Roubo.class;
	}

}
