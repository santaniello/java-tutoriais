package br.com.twf.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.model.beans.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
