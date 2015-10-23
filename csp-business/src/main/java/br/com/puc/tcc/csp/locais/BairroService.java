package br.com.puc.tcc.csp.locais;

import static java.util.Collections.emptySet;

import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.locais.Bairro;
import br.com.puc.tcc.csp.model.locais.Logradouro;
import br.com.puc.tcc.csp.repository.locais.BairroRepository;

/**
 * Classe de negócios referente aos logradouros.
 */
@Stateless
@LocalBean
public class BairroService{

	@Inject
	private BairroRepository repository;
	
	public List<Bairro> getAll(){
		return repository.fetchAll();
	}

	public Bairro getBairroById(Long id) {
		return repository.fetchCompleteById(id);
	}

	public Set<Logradouro> getLogradourosFromBairro(Long id) {
		Bairro bairro = this.getBairroById(id);
		if(bairro != null){
			return bairro.getLogradouros();
		}
		return emptySet();
	}

}
