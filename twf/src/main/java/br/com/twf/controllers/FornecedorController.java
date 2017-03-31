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
import br.com.twf.model.beans.Fornecedor;
import br.com.twf.services.ClienteServiceImpl;
import br.com.twf.services.FornecedorService;
import br.com.twf.services.ClienteService;

@RestController
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class FornecedorController {
	
	private static final Logger logger = LoggerFactory.getLogger(FornecedorController.class);
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@RequestMapping(value="/fornecedores", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Fornecedor cliente){
		if(fornecedorService.save(cliente).getId() > 0){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/fornecedores/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Fornecedor cliente, @PathVariable String id){
		try {
			fornecedorService.save(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@RequestMapping(value="/fornecedores/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Fornecedor> getById(@PathVariable String id){
		Fornecedor fornecedor = fornecedorService.findById(Long.parseLong(id));				
		if(fornecedor != null){
			return new ResponseEntity<Fornecedor>(fornecedor,HttpStatus.OK);
		}		
		return new ResponseEntity<Fornecedor>(HttpStatus.NOT_FOUND);		
	}	
			
	@RequestMapping(value="/fornecedores", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Fornecedor>> listAll(){
		List<Fornecedor> fornecedores = fornecedorService.findAll();		
		if(fornecedores != null){
			return new ResponseEntity<List<Fornecedor>>(fornecedores,HttpStatus.OK);
		}	
		return new ResponseEntity<List<Fornecedor>>(HttpStatus.NO_CONTENT);
			
	}
	
	@RequestMapping(value="/fornecedores/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Fornecedor> delete(@PathVariable String id){
		fornecedorService.delete(fornecedorService.findById(Long.parseLong(id)));		
		if(fornecedorService.findById(Long.parseLong(id)) == null){
			return new ResponseEntity<Fornecedor>(HttpStatus.OK);		
		}
		return new ResponseEntity<Fornecedor>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}
