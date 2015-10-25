package br.com.puc.tcc.csp.repository.locais;

import static java.util.Collections.singletonList;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Entidade;
import br.com.puc.tcc.csp.model.locais.Zona;
import br.com.puc.tcc.csp.model.locais.Zona_;

public class ZonaRepository extends RepositoryEssentials<Zona>{

	@Override
	protected Class<Zona> getEntityType() {
		return Zona.class;
	}

	@Override
	protected List<SetAttribute<Zona, ? extends Entidade>> getSetAttributes() {
		return singletonList(Zona_.bairros);
	}
	
	@Override
	protected List<SingularAttribute<Zona, ? extends Entidade>> getSingularAttributes() {
		return singletonList(Zona_.cidade);
	}

}
