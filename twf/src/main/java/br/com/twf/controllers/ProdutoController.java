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

import br.com.twf.model.beans.Marca;
import br.com.twf.model.beans.Produto;
import br.com.twf.services.MarcaService;
import br.com.twf.services.ProdutoService;

@RestController
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class ProdutoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value="/produtos", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Produto produto){
		if(produtoService.save(produto).getId() > 0){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/produtos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Produto produto, @PathVariable String id){
		try {
			produtoService.save(produto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@RequestMapping(value="/produtos/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Produto> getById(@PathVariable String id){
		Produto produto = produtoService.findById(Long.parseLong(id));				
		if(produto != null){
			return new ResponseEntity<Produto>(produto,HttpStatus.OK);
		}		
		return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);		
	}	
			
	@RequestMapping(value="/produtos", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Produto>> listAll(){
		List<Produto> produtos = produtoService.findAll();		
		if(produtos != null){
			return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
		}	
		return new ResponseEntity<List<Produto>>(HttpStatus.NO_CONTENT);
			
	}
	
	@RequestMapping(value="/produtos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Produto> delete(@PathVariable String id){
		produtoService.delete(produtoService.findById(Long.parseLong(id)));		
		if(produtoService.findById(Long.parseLong(id)) == null){
			return new ResponseEntity<Produto>(HttpStatus.OK);		
		}
		return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
		
	
	// *********************************** Categoria Produto ************************************************
	
	
		@RequestMapping(value="/produtos/marcas", method = RequestMethod.POST)
		public ResponseEntity<Void> saveMarca(@RequestBody Marca marca){
			if(marcaService.save(marca).getId() > 0){
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@RequestMapping(value="/produtos/marcas", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
		public ResponseEntity<List<Marca>> listAllMarcas(){
			List<Marca> marcas = marcaService.findAll();		
			if(marcas != null){
				return new ResponseEntity<List<Marca>>(marcas,HttpStatus.OK);
			}	
			return new ResponseEntity<List<Marca>>(HttpStatus.NO_CONTENT);
				
		}
		
		
}
