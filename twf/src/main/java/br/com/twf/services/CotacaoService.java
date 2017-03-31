package br.com.twf.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.beans.Cotacao;
import br.com.twf.model.beans.Marca;
import br.com.twf.model.beans.Produto;

@Component
public interface CotacaoService extends Service<Cotacao>  {	
	public List<Cotacao> findByProduto(Produto produto);
}
