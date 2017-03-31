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

import br.com.twf.model.beans.Cotacao;
import br.com.twf.model.beans.Produto;
import br.com.twf.services.CotacaoService;
import br.com.twf.services.ProdutoService;

@RestController
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class) 
public class CotacaoController {
	
	private static final Logger logger = LoggerFactory.getLogger(CotacaoController.class);
	
	@Autowired
	private CotacaoService cotacaoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/cotacoes", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Cotacao cotacao){
		
		    cotacaoService.save(cotacao);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/cotacoes", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cotacao>> listAll(){
		List<Cotacao> cotacoes = cotacaoService.findAll();		
		if(cotacoes != null){
			return new ResponseEntity<List<Cotacao>>(cotacoes,HttpStatus.OK);
		}	
		return new ResponseEntity<List<Cotacao>>(HttpStatus.NO_CONTENT);
			
	}
	
	
	@RequestMapping(value="/cotacoes/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Cotacao>> getByIdProduto(@PathVariable String id){
		System.out.println(id);
		Produto produto = produtoService.findById(Long.parseLong(id));
		
		System.out.println("Nome do produto = " + produto.getNome());
		
		List<Cotacao> cotacoes = cotacaoService.findByProduto(produtoService.findById(Long.parseLong(id)));				
		if(cotacoes != null){
			return new ResponseEntity<List<Cotacao>>(cotacoes,HttpStatus.OK);
		}		
		return new ResponseEntity<List<Cotacao>>(HttpStatus.NOT_FOUND);		
	}	
		
		
}
