package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.model.beans.Produto;
import br.com.twf.model.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Override
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Produto findById(long id) {
		return produtoRepository.findOne(id);
	}

	@Override
	public List<Produto> findAll() {
		return (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public void delete(Produto produto) {
		produtoRepository.delete(produto);		
	}

		
}
