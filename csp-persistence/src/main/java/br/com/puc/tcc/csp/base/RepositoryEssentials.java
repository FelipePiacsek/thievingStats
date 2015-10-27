
package br.com.puc.tcc.csp.base;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public abstract class RepositoryEssentials<T> {

	/**
	 * Entity manager.
	 */
	@Inject
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return this.em;
	}
	
	protected abstract Class<T> getEntityType();
	
	public <E> E getSingleResult(final CriteriaQuery<E> query){
		List<E> resultList = em.createQuery(query).setMaxResults(1).getResultList();
		return resultList.size() > 0 ? resultList.get(0) : null;
	}
	
	public List<T> getResults(final CriteriaQuery<T> query){
		return em.createQuery(query).getResultList();
	}
	
    public List<T> fetchAll(){
		CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<T> from = query.from(getEntityType());
        return getResults(query);
	}
    
    public T fetchById(Long id){
		return em.find(getEntityType(), id);
	}
    
    public void save(T t){
    	em.merge(t);
    }
}
