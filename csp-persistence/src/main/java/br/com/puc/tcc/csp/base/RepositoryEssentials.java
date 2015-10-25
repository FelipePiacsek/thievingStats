
package br.com.puc.tcc.csp.base;

import static java.util.Collections.emptyList;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;

import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.Entidade_;

public abstract class RepositoryEssentials<T extends Entidade> {

	/**
	 * Entity manager.
	 */
	@Inject
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return this.em;
	}
	
	protected abstract Class<T> getEntityType();
	
	protected List<SetAttribute<T, ? extends Entidade>> getSetAttributes(){
		return emptyList();
	}

	protected List<SingularAttribute<T, ? extends Entidade>> getSingularAttributes(){
		return emptyList();
	}
	
	public <E> E getSingleResult(final CriteriaQuery<E> query){
		List<E> resultList = em.createQuery(query).setMaxResults(1).getResultList();
		return resultList.size() > 0 ? resultList.get(0) : null;
	}
	
	public List<T> getResults(final CriteriaQuery<T> query){
		return em.createQuery(query).getResultList();
	}
	
    public boolean exists(final CriteriaQuery<Integer> query, final CriteriaBuilder builder) {
        return getSingleResult(query.select(builder.literal(1))) != null;
    }
    
    public List<T> fetchAll(){
		CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<T> from = query.from(getEntityType());
        return getResults(query);
	}
    
    public T fetchById(Long id){
		CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<T> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.equal(from.get(Entidade_.id), id));
		return getSingleResult(query);
	}
    
    
    public T fetchCompleteById(Long id){
    	CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
    	Root<T> from = query.from(getEntityType());
    	CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    	
    	for (SetAttribute<T, ? extends Entidade> setAttribute : getSetAttributes()) {
			from.fetch(setAttribute);
		}

    	for (SingularAttribute<T, ? extends Entidade> singularAttribute : getSingularAttributes()) {
    		from.fetch(singularAttribute);
		}
    	
    	query.where(cb.equal(from.get(Entidade_.id), id));
    	return getSingleResult(query);
    }
    
    
}
