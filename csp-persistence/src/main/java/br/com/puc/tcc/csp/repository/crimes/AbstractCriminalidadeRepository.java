package br.com.puc.tcc.csp.repository.crimes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia_;
import br.com.puc.tcc.csp.model.locais.Logradouro;

public abstract class AbstractCriminalidadeRepository<T extends Ocorrencia> extends RepositoryEssentials<T> {
	
	public List<T> getOcorrenciasByLogradouroEDatas(Logradouro logradouro, Timestamp dataInicio, Timestamp dataFim){
		CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<T> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime), logradouro), 
						   cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
	@Override
	protected List<SingularAttribute<T, ? extends Entidade>> getSingularAttributes() {
		List<SingularAttribute<T, ? extends Entidade>> atributos = new ArrayList<SingularAttribute<T, ? extends Entidade>>();
		SingularAttribute<T, ? extends Entidade> local =  (SingularAttribute<T, ? extends Entidade>) Ocorrencia_.localDoCrime;
		atributos.add(local);
		return atributos;
	}

}
