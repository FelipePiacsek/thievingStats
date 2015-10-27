package br.com.puc.tcc.csp.repository.locais;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.model.locais.Zona_;

public class ZonaRepository extends RepositoryEssentials<Zona>{

	private CriteriaQuery<Zona> query;

	private Root<Zona> from;
	
	private CriteriaBuilder cb;
	
	private void initialize() {
		query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		cb = getEntityManager().getCriteriaBuilder();
		from = query.from(getEntityType());
	}

	@Override
	protected Class<Zona> getEntityType() {
		return Zona.class;
	}

	public Zona fetchCompleteById(Long id) {
		initialize();
		from.fetch(Zona_.bairros);
		query.where(cb.equal(from.get(Zona_.id), id));
		return getSingleResult(query);
	}

}
