package br.com.puc.tcc.csp.repository.crimes;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
	
	CriteriaBuilder cb;
	
	private void initialize() {
		query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		from = query.from(getEntityType());
		cb = getEntityManager().getCriteriaBuilder();
	}

	public List<T> getOcorrenciasByLogradouroEDatas(Logradouro logradouro, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime), logradouro), 
						   cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	

	public List<T> getOcorrenciasByBairroEDatas(Bairro bairro, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime).get(Logradouro_.bairro), bairro), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
	public List<T> getOcorrenciasByZonaEDatas(Zona zona, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime).get(Logradouro_.bairro).get(Bairro_.zona), zona), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
	public List<T> getOcorrenciasByCidadeEDatas(Cidade cidade, Timestamp dataInicio, Timestamp dataFim){
		initialize();
		query.where(cb.and(cb.equal(from.get(Ocorrencia_.localDoCrime).get(Logradouro_.bairro).get(Bairro_.zona).get(Zona_.cidade), cidade), 
				cb.between(from.get(Ocorrencia_.dataOcorrencia), dataInicio, dataFim)));
		return getResults(query);
	}
	
}
