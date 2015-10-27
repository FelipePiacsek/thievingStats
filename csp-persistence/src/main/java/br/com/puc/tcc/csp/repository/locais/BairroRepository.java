package br.com.puc.tcc.csp.repository.locais;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Bairro_;

public class BairroRepository extends RepositoryEssentials<Bairro>{
    
	private CriteriaQuery<Bairro> query;

	private Root<Bairro> from;
	
	private CriteriaBuilder cb;
	
	private void initialize() {
		query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		cb = getEntityManager().getCriteriaBuilder();
		from = query.from(getEntityType());
	}

	@Override
	protected Class<Bairro> getEntityType() {
		return Bairro.class;
	}

	public Bairro fetchCompleteById(Long id) {
		initialize();
		from.fetch(Bairro_.logradouros);
		query.where(cb.equal(from.get(Bairro_.id), id));
		return getSingleResult(query);
	}}
