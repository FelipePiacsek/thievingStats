package br.com.puc.tcc.csp.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Configuracao;
import br.com.puc.tcc.csp.model.Configuracao_;

public class ConfiguracoesRepository extends RepositoryEssentials<Configuracao> {

	@Override
	protected Class<Configuracao> getEntityType() {
		return Configuracao.class;
	}

	public Configuracao fetchProperty(String key){
		CriteriaQuery<Configuracao> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Configuracao> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.equal(from.get(Configuracao_.chave), key));
		return getSingleResult(query);
	}
}
