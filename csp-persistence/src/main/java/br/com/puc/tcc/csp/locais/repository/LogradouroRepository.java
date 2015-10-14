package br.com.puc.tcc.csp.locais.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import br.com.puc.tcc.csp.locais.model.Logradouro;

public class LogradouroRepository {

    /**
     * Entity Manager.
     */
    @Inject
    private EntityManager em;
    
	public List<Logradouro> fetchAll(){
		CriteriaQuery<Logradouro> cq = em.getCriteriaBuilder().createQuery(getEntityType());
        cq.select(cq.from(getEntityType()));
        return em.createQuery(cq).getResultList();
	}

	private Class<Logradouro> getEntityType() {
		return Logradouro.class;
	}
}
