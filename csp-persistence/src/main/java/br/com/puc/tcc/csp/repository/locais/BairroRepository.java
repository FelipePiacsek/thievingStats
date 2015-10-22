package br.com.puc.tcc.csp.repository.locais;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.BaseRepository;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Bairro_;

public class BairroRepository extends BaseRepository<Bairro>{
    
	@Override
	protected Class<Bairro> getEntityType() {
		return Bairro.class;
	}
	
	public List<Bairro> fetchAll(){
		CriteriaQuery<Bairro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Bairro> from = query.from(getEntityType());
        return getEntityManager().createQuery(query).getResultList();
	}

	public Bairro fetchById(Long id) {
		CriteriaQuery<Bairro> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Bairro> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Bairro_.logradouros);
		query.where(cb.equal(from.get(Bairro_.id), id));
		
		return getEntityManager().createQuery(query).getSingleResult();
	}


}
