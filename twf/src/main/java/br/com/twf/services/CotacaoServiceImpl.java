package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.model.beans.Cotacao;
import br.com.twf.model.beans.CotacaoProdutoId;
import br.com.twf.model.beans.Fornecedor;
import br.com.twf.model.beans.Produto;
import br.com.twf.model.repositories.CotacaoRepository;
import br.com.twf.model.repositories.FornecedorRepository;
import br.com.twf.model.repositories.ProdutoRepository;

@Service
public class CotacaoServiceImpl implements CotacaoService{

	@Autowired
	private CotacaoRepository cotacaoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Cotacao save(Cotacao cotacao) {
		
		System.out.println("O código do fornecedor é " + cotacao.getFornecedor().getId());
		cotacao.setFornecedor(fornecedorRepository.findOne(cotacao.getFornecedor().getId()));
		cotacao.setProduto(produtoRepository.findOne(cotacao.getProduto().getId()));
		return cotacaoRepository.save(cotacao);
	}

	@Override
	public Cotacao findById(long id) {
		//return cotacaoRepository.findOne(id);
	return null;
	}

	@Override
	public List<Cotacao> findAll() {
		return (List<Cotacao>) cotacaoRepository.findAll();
	}

	@Override
	public void delete(Cotacao marca) {
		cotacaoRepository.delete(marca);		
	}
	
	public List<Cotacao> findByProduto(Produto produto){
		return cotacaoRepository.findByProduto(produto);
	}
	
	
}
