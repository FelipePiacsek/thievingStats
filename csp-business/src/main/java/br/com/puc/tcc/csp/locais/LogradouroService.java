package br.com.puc.tcc.csp.locais;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.puc.tcc.csp.locais.model.Logradouro;
import br.com.puc.tcc.csp.locais.repository.LogradouroRepository;

/**
 * Classe de negócios referente aos logradouros.
 */
@Stateless
@LocalBean
public class LogradouroService{

	@Inject
	private LogradouroRepository repository;
	
	public List<Logradouro> getAll(){
		return repository.fetchAll();
	}
}
