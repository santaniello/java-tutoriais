package br.com.twf.model.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import br.com.twf.model.beans.Usuario;



@Repository
public class UsuarioDAO  {

	@PersistenceContext
	private EntityManager manager;

	private Logger log = Logger.getLogger(UsuarioDAO.class);

	
	public Usuario gravar(Usuario obj) throws Exception {
		try {
			manager.persist(obj);
		} catch (HibernateError error) {
			log.error(error.getMessage());
		} catch (HibernateException exception) {
			log.error(exception.getMessage());
		} catch (IllegalArgumentException argument) {
			log.error(argument.getMessage());
		} catch (IllegalStateException entityManager) {
			log.error(entityManager.getMessage());
		} catch (NullPointerException nullPointer) {
			log.error(nullPointer.getMessage());
		}

		return obj;
	}

	
	
	public void remover(long id) {
		Usuario usuario = null;
		try {
			usuario = manager.find(Usuario.class, id);
			if (usuario != null) {
				manager.remove(usuario);
			}
		} catch (HibernateError error) {
			log.error(error.getMessage());
		} catch (HibernateException exception) {
			log.error(exception.getMessage());
		} catch (IllegalArgumentException argument) {
			log.error(argument.getMessage());
		} catch (IllegalStateException entityManager) {
			log.error(entityManager.getMessage());
		} catch (NullPointerException nullPointer) {
			log.error(nullPointer.getMessage());
		}
	}

	
	public Usuario consultar(long id) {
		Usuario usuario = null;
		try {
			usuario = manager.find(Usuario.class, id);
		} catch (HibernateError error) {
			log.error(error.getMessage());
		} catch (HibernateException exception) {
			log.error(exception.getMessage());
		} catch (IllegalArgumentException argument) {
			log.error(argument.getMessage());
		} catch (IllegalStateException entityManager) {
			log.error(entityManager.getMessage());
		} catch (NullPointerException nullPointer) {
			log.error(nullPointer.getMessage());
		} catch (Exception exception) {
			log.error(exception.getMessage());
		}
		return usuario;
	}

	
	public List<Usuario> listar() {
		List<Usuario> usuarios = null;
		try {
			TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u ", Usuario.class);
			usuarios = query.getResultList();
		} catch (NoResultException e) {
			log.error(e.getMessage());
			return null;
		}
		return usuarios;
	}
		
}
