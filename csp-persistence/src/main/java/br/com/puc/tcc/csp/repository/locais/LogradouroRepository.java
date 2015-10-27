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

	private CriteriaQuery<Logradouro> query;

	private Root<Logradouro> from;
	
	private CriteriaBuilder cb;
	
	private void initialize() {
		query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		cb = getEntityManager().getCriteriaBuilder();
		from = query.from(getEntityType());
	}
	
	@Override
	protected Class<Logradouro> getEntityType() {
		return Logradouro.class;
	}
	
	public Logradouro fetchLogradouroByCep(String cep){
		initialize();
		from.fetch(Logradouro_.bairro, JoinType.LEFT).fetch(Bairro_.zona, JoinType.LEFT);
		from.fetch(Logradouro_.tipo, JoinType.LEFT);
		query.where(cb.equal(from.get(Logradouro_.cep), cep));
		return getSingleResult(query);
	}

	public Logradouro fetchCompleteById(Long id) {
		initialize();
		from.fetch(Logradouro_.bairro, JoinType.LEFT).fetch(Bairro_.zona, JoinType.LEFT);
		from.fetch(Logradouro_.tipo, JoinType.LEFT);
		query.where(cb.equal(from.get(Logradouro_.id), id));
		return getSingleResult(query);
	}

	public boolean existe(String cep) {
		return this.fetchLogradouroByCep(cep) != null;
	}

}
