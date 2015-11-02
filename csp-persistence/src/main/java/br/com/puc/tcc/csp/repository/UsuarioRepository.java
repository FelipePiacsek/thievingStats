package br.com.puc.tcc.csp.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.puc.tcc.csp.base.RepositoryEssentials;
import br.com.puc.tcc.csp.model.Usuario;
import br.com.puc.tcc.csp.model.Usuario_;
import br.com.puc.tcc.csp.model.locais.Bairro_;
import br.com.puc.tcc.csp.model.locais.Logradouro_;
import br.com.puc.tcc.csp.model.locais.Zona_;

public class UsuarioRepository extends RepositoryEssentials<Usuario> {

	@Override
	protected Class<Usuario> getEntityType() {
		return Usuario.class;
	}

	public boolean existe(Usuario usuario) {
		CriteriaQuery<Usuario> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Usuario> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		query.where(cb.equal(from.get(Usuario_.email), usuario.getEmail()));
		return !getResults(query).isEmpty();
	}

	public Usuario fetchCompleteByEmail(String email){
		CriteriaQuery<Usuario> query = getEntityManager().getCriteriaBuilder().createQuery(getEntityType());
		Root<Usuario> from = query.from(getEntityType());
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		from.fetch(Usuario_.residencia).fetch(Logradouro_.bairro).fetch(Bairro_.zona).fetch(Zona_.cidade);
		query.where(cb.equal(from.get(Usuario_.email), email));
		return getSingleResult(query);
	}
}
