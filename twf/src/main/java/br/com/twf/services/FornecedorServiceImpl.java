package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.model.beans.Fornecedor;
import br.com.twf.model.repositories.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Override
	public Fornecedor save(Fornecedor fornecedor) {
		
		return fornecedorRepository.save(fornecedor);
	}

	@Override
	public Fornecedor findById(long id) {
		return fornecedorRepository.findOne(id);
	}

	@Override
	public List<Fornecedor> findAll() {
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}

	@Override
	public void delete(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);		
	}

	

}
