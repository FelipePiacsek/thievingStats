package br.com.puc.tcc.csp.repository.crimes;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.model.crimes.LesaoCorporal;
import br.com.puc.tcc.csp.model.crimes.LesaoCorporal_;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia_;
import br.com.puc.tcc.csp.model.locais.Logradouro;

public class LesaoCorporalRepository extends AbstractCriminalidadeRepository<LesaoCorporal> {

	@Override
	protected Class<LesaoCorporal> getEntityType() {
		return LesaoCorporal.class;
	}

	public List<LesaoCorporal> getLesoesByTipoELogradouro(LesaoCorporal.TipoLesao tipoLesao, Logradouro logradouro){
		CriteriaQuery<LesaoCorporal> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<LesaoCorporal> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime), logradouro), 
				          cb.equal(from.get(LesaoCorporal_.tipo), tipoLesao)));
		return getResults(query);
	}
}
