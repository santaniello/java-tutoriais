package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.CategoriaProduto;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.repositories.CategoriaProdutoRepository;

@Service
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

	@Autowired
	private CategoriaProdutoRepository categoriaRepository;
	
	@Override
	public CategoriaProduto save(CategoriaProduto categoria){
		return categoriaRepository.save(categoria);
	}
	
	@Override
	public CategoriaProduto findById(long id){
		return categoriaRepository.findOne(id);		
	}
	
	@Override
	public List<CategoriaProduto> findAll(){
		return (List<CategoriaProduto>) categoriaRepository.findAll();		
	}
	
	@Override
	public void delete(CategoriaProduto cliente){
		categoriaRepository.delete(cliente);
	}	
		
}
