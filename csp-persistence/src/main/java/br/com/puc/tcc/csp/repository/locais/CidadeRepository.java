package br.com.puc.tcc.csp.repository.locais;

import static java.util.Collections.singletonList;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.locais.Cidade;
import br.com.puc.tcc.csp.model.locais.Cidade_;

public class CidadeRepository extends RepositoryEssentials<Cidade> {

	@Override
	protected Class<Cidade> getEntityType() {
		return Cidade.class;
	}

	@Override
	protected List<SetAttribute<Cidade, ? extends Entidade>> getSetAttributes() {
		return singletonList(Cidade_.zonas);
	}

}
