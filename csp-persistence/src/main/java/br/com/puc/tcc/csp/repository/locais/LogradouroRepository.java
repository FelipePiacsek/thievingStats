package br.com.puc.tcc.csp.repository.locais;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Logradouro_;

public class LogradouroRepository extends RepositoryEssentials<Logradouro>{

	public List<Logradouro> fetchAll(){
		CriteriaQuery<Logradouro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Logradouro> from = query.from(getEntityType());
        return getResults(query);
	}
	
	public Logradouro fetchLogradouroByCep(String cep){
		CriteriaQuery<Logradouro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Logradouro> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Logradouro_.bairro, JoinType.LEFT);
		query.where(cb.equal(from.get(Logradouro_.cep), cep));
		return getSingleResult(query);
	}

	@Override
	protected Class<Logradouro> getEntityType() {
		return Logradouro.class;
	}
}
