package br.com.twf.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.twf.model.beans.Cliente;
import br.com.twf.services.ClienteServiceImpl;
import br.com.twf.services.ClienteService;

@RestController
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class ClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/clientes", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Cliente cliente){
		if(clienteService.save(cliente).getId() > 0){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/clientes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable String id){
		try {
			clienteService.save(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@RequestMapping(value="/clientes/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Cliente> getById(@PathVariable String id){
		Cliente cliente = clienteService.findById(Long.parseLong(id));				
		if(cliente != null){
			return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		}		
		return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);		
	}	
			
	@RequestMapping(value="/clientes", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cliente>> listAll(){
		List<Cliente> clientes = clienteService.findAll();		
		if(clientes != null){
			return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
		}	
		return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
			
	}
	
	@RequestMapping(value="/clientes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Cliente> delete(@PathVariable String id){
		clienteService.delete(clienteService.findById(Long.parseLong(id)));		
		if(clienteService.findById(Long.parseLong(id)) == null){
			return new ResponseEntity<Cliente>(HttpStatus.OK);		
		}
		return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
