package br.com.twf.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	List<Cliente> findByStatus(Status status);	
}
