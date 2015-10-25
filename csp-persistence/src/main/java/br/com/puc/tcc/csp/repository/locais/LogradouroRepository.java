package br.com.puc.tcc.csp.repository.locais;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Bairro_;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Logradouro_;

public class LogradouroRepository extends RepositoryEssentials<Logradouro>{

	@Override
	protected Class<Logradouro> getEntityType() {
		return Logradouro.class;
	}
	
	public Logradouro fetchLogradouroByCep(String cep){
		return fetchComplete(null, cep);
	}

	@Override
	public Logradouro fetchCompleteById(Long id) {
		return fetchComplete(id, null);
	}
	
	private Logradouro fetchComplete(Long id, String cep){
		if(id == null && cep == null){
			throw new IllegalArgumentException();
		}
		CriteriaQuery<Logradouro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Logradouro> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Logradouro_.bairro, JoinType.LEFT).fetch(Bairro_.zona, JoinType.LEFT);
		if(id != null){
			query.where(cb.equal(from.get(Logradouro_.id), id));
		}else{
			query.where(cb.equal(from.get(Logradouro_.cep), cep));
		}
		return getSingleResult(query);
	}
}
