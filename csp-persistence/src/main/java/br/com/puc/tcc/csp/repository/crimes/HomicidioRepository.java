package br.com.puc.tcc.csp.repository.crimes;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.model.crimes.Homicidio;
import br.com.puc.tcc.csp.model.crimes.Homicidio_;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia_;
import br.com.puc.tcc.csp.model.locais.Logradouro;

public class HomicidioRepository extends AbstractCriminalidadeRepository<Homicidio> {

	@Override
	protected Class<Homicidio> getEntityType() {
		return Homicidio.class;
	}

	public List<Homicidio> getHomicidiosByQualificacaoELogradouro(Homicidio.Qualificacao qualificacao, Logradouro logradouro){
		CriteriaQuery<Homicidio> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Homicidio> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime), logradouro), 
				          cb.equal(from.get(Homicidio_.qualificacao), qualificacao)));
		return getResults(query);
	}
}
