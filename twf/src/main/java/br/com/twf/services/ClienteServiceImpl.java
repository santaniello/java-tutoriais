package br.com.twf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	@Override
	public Cliente findById(long id){
		return clienteRepository.findOne(id);		
	}
	
	@Override
	public List<Cliente> findAll(){
		return (List<Cliente>) clienteRepository.findAll();		
	}
	
	@Override
	public void delete(Cliente cliente){
		clienteRepository.delete(cliente);
	}	
	
	public List<Cliente> findByStatus(Status status){
		return (List<Cliente>) clienteRepository.findByStatus(status);		
	}	
}
