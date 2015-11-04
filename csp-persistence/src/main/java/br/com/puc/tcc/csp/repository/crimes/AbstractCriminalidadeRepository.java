package br.com.puc.tcc.csp.repository.crimes;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia;
import br.com.puc.tcc.csp.model.crimes.Ocorrencia_;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Bairro_;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.model.locais.Logradouro_;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.model.locais.Zona_;

public abstract class AbstractCriminalidadeRepository<T extends Ocorrencia> extends RepositoryEssentials<T> {
	
	private CriteriaQuery<T> query;
	
	private Root<T> from;
	
	private CriteriaBuilder cb;
	
	private void initialize() {
		query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		from = query.from(getEntityType());
		cb = getEntityManager().getCriteriaBuilder();
	}

	public List<T> getOcorrenciasByLogradouroEDatas(Logradouro logradouro, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		Join<T, Logradouro> joinLogradouro = from.join(Ocorrencia_.localDoCrime);
		query.where(cb.and(cb.equal(joinLogradouro, logradouro), 
						   cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	

	public List<T> getOcorrenciasByBairroEDatas(Bairro bairro, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		Join<Logradouro,Bairro> joinBairro = from.join(Ocorrencia_.localDoCrime, JoinType.LEFT).join(Logradouro_.bairro, JoinType.LEFT);
		query.where(cb.and(cb.equal(joinBairro, bairro), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
	public List<T> getOcorrenciasByZonaEDatas(Zona zona, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		Join<Bairro, Zona> joinZona = from.join(Ocorrencia_.localDoCrime, JoinType.LEFT).join(Logradouro_.bairro, JoinType.LEFT)
				.join(Bairro_.zona, JoinType.LEFT);
		query.where(cb.and(cb.equal(joinZona, zona), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
	public List<T> getOcorrenciasByCidadeEDatas(Cidade cidade, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		Join<Zona, Cidade> joinCidade = from.join(Ocorrencia_.localDoCrime, JoinType.LEFT).join(Logradouro_.bairro, JoinType.LEFT)
				.join(Bairro_.zona, JoinType.LEFT).join(Zona_.cidade, JoinType.LEFT);
		query.where(cb.and(cb.equal(joinCidade, cidade), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
}
