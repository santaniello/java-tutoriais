package br.com.twf.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.beans.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
	
	List<Fornecedor> findByStatus(Status status);	
}
