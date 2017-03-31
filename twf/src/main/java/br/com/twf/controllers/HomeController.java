package br.com.twf.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.twf.model.beans.Cotacao;
import br.com.twf.model.beans.Produto;
import br.com.twf.services.CotacaoServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CotacaoServiceImpl service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
			
		return "index";
	}
	
	@RequestMapping(value="/form/clientes",method = RequestMethod.GET)
	public ModelAndView getFormCadastroCliente(){
		ModelAndView mv = new ModelAndView("pages/formCliente");
		mv.addObject("tituloForm", "Cadastro de cliente");
		mv.addObject("tituloBotao", "Gravar");
		return mv;
	}
	
	@RequestMapping(value="/form/clientes/{id}",method = RequestMethod.GET)
	public ModelAndView getFormUpdateCliente(@PathVariable String id){
		ModelAndView mv = new ModelAndView("pages/formCliente");
		mv.addObject("id", id);
		mv.addObject("tituloForm", "Alteração de cliente");
		mv.addObject("tituloBotao", "Alterar");
		return mv;
	}
	
	@RequestMapping(value="/list/clientes",method = RequestMethod.GET)
	public String getListCliente(){
		return "pages/listaClientes";
	}
	
	@RequestMapping(value="/form/fornecedores",method = RequestMethod.GET)
	public ModelAndView getFormFornecedor(){
		ModelAndView mv = new ModelAndView("pages/formFornecedor");
		mv.addObject("tituloForm", "Cadastro de Fornecedor");
		mv.addObject("tituloBotao", "Gravar");
		return mv;
	}
	
	@RequestMapping(value="/form/fornecedores/{id}",method = RequestMethod.GET)
	public ModelAndView getFormUpdateFornecedor(@PathVariable String id){
		ModelAndView mv = new ModelAndView("pages/formFornecedor");
		mv.addObject("id", id);
		mv.addObject("tituloForm", "Alteração de fornecedor");
		mv.addObject("tituloBotao", "Alterar");
		return mv;
	}
		
	@RequestMapping(value="/list/fornecedores",method = RequestMethod.GET)
	public String getListFornecedores(){
		return "pages/listaFornecedores";
	}		
	
	
	@RequestMapping(value="/form/produtos",method = RequestMethod.GET)
	public ModelAndView getFormProduto(){
		ModelAndView mv = new ModelAndView("pages/formProduto");
		mv.addObject("tituloForm", "Cadastro de Produto");
		mv.addObject("tituloBotao", "Gravar");
		return mv;
	}
	
	@RequestMapping(value="/form/produtos/{id}",method = RequestMethod.GET)
	public ModelAndView getFormUpdateProduto(@PathVariable String id){
		ModelAndView mv = new ModelAndView("pages/formProduto");
		mv.addObject("id", id);
		mv.addObject("tituloForm", "Alteração de Produto");
		mv.addObject("tituloBotao", "Alterar");
		return mv;
	}
	
	@RequestMapping(value="/list/produtos",method = RequestMethod.GET)
	public String getListProdutos(){
		return "pages/listaProdutos";
	}			
}
