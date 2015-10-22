package br.com.puc.tcc.csp.repository.locais;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.BaseRepository;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Logradouro_;

public class LogradouroRepository extends BaseRepository<Logradouro>{

	public List<Logradouro> fetchAll(){
		CriteriaQuery<Logradouro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Logradouro> from = query.from(getEntityType());
		from.fetch(Logradouro_.bairro, JoinType.LEFT);
        return getEntityManager().createQuery(query).getResultList();
	}
	
	public Logradouro fetchLogradouroByCep(String cep){
		CriteriaQuery<Logradouro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Logradouro> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.equal(from.get(Logradouro_.cep), cep));
		
		return getEntityManager().createQuery(query).getSingleResult();
	}

	@Override
	protected Class<Logradouro> getEntityType() {
		return Logradouro.class;
	}
}
