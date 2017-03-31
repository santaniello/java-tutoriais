package br.com.twf.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.model.beans.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long> {
	

}
