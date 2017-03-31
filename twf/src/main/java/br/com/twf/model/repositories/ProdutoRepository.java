package br.com.twf.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.beans.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
}
