
package br.com.puc.tcc.csp.base;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class BaseRepository<T> {

	/**
	 * Entity manager.
	 */
	@Inject
	private EntityManager em;
	
	protected EntityManager getEntityManager(){
		return this.em;
	}
	
	protected abstract Class<T> getEntityType();
}
