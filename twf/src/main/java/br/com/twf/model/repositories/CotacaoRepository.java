package br.com.twf.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.twf.model.beans.Cotacao;
import br.com.twf.model.beans.CotacaoProdutoId;
import br.com.twf.model.beans.Produto;

@Repository
public interface CotacaoRepository extends CrudRepository<Cotacao, CotacaoProdutoId> {
	 
	List<Cotacao> findByProduto(Produto produto);

}
