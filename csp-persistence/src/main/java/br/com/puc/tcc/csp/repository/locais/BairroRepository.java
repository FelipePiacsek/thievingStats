package br.com.puc.tcc.csp.repository.locais;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Bairro_;

public class BairroRepository extends RepositoryEssentials<Bairro>{
    
	@Override
	protected Class<Bairro> getEntityType() {
		return Bairro.class;
	}

	public Bairro fetchCompleteById(Long id) {
		CriteriaQuery<Bairro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Bairro> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Bairro_.logradouros, JoinType.LEFT);
		from.fetch(Bairro_.zona, JoinType.LEFT);
		query.where(cb.equal(from.get(Bairro_.id), id));
		
		return getSingleResult(query);
	}


}
