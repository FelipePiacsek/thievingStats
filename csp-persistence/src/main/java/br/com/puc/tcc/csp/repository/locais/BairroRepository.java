package br.com.puc.tcc.csp.repository.locais;

import static java.util.Collections.singletonList;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Bairro_;

public class BairroRepository extends RepositoryEssentials<Bairro>{
    
	@Override
	protected Class<Bairro> getEntityType() {
		return Bairro.class;
	}

	@Override
	protected List<SetAttribute<Bairro, ? extends Entidade>> getSetAttributes() {
		return singletonList(Bairro_.logradouros);
	}

	@Override
	protected List<SingularAttribute<Bairro, ? extends Entidade>> getSingularAttributes() {
		return singletonList(Bairro_.zona);
	}
}
