package br.com.puc.tcc.csp.locais;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.model.locais.Bairro;
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

	public Bairro geBairroById(Long id) {
		return repository.fetchById(id);
	}
}