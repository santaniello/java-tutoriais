package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.model.beans.Marca;
import br.com.twf.model.repositories.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public Marca save(Marca marca) {
		return marcaRepository.save(marca);
	}

	@Override
	public Marca findById(long id) {
		return marcaRepository.findOne(id);
	}

	@Override
	public List<Marca> findAll() {
		return (List<Marca>) marcaRepository.findAll();
	}

	@Override
	public void delete(Marca marca) {
		marcaRepository.delete(marca);		
	}
	
	
}
