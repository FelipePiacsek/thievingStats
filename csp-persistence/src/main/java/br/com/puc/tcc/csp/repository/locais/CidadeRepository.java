package br.com.puc.tcc.csp.repository.locais;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.locais.Bairro_;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.model.locais.Cidade_;
import br.com.puc.tcc.csp.model.locais.Zona_;

public class CidadeRepository extends RepositoryEssentials<Cidade> {

	@Override
	protected Class<Cidade> getEntityType() {
		return Cidade.class;
	}

	@Override
	public Cidade fetchCompleteById(Long id) {
		CriteriaQuery<Cidade> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Cidade> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Cidade_.zonas).fetch(Zona_.bairros).fetch(Bairro_.logradouros);
		query.where(cb.equal(from.get(Cidade_.id), id));
		return getSingleResult(query);
	}

}
