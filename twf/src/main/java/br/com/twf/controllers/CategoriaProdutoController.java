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

import br.com.twf.model.beans.CategoriaProduto;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.beans.Marca;
import br.com.twf.services.ClienteServiceImpl;
import br.com.twf.services.MarcaService;
import br.com.twf.services.CategoriaProdutoService;
import br.com.twf.services.ClienteService;

@RestController
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class CategoriaProdutoController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoriaProdutoController.class);
	
	@Autowired
	private CategoriaProdutoService categoriaService;
	
	@RequestMapping(value="/categoriasProduto", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody CategoriaProduto categoria){
		if(categoriaService.save(categoria).getId() > 0){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value="/categoriasProduto", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<CategoriaProduto>> listAll(){
		List<CategoriaProduto> categorias = categoriaService.findAll();		
		if(categorias != null){
			return new ResponseEntity<List<CategoriaProduto>>(categorias,HttpStatus.OK);
		}	
		return new ResponseEntity<List<CategoriaProduto>>(HttpStatus.NO_CONTENT);			
	}
		
}
