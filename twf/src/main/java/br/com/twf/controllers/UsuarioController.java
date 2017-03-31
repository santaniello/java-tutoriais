package br.com.twf.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.twf.model.beans.Usuario;
import br.com.twf.services.UsuarioService;

/**
 * Handles requests for the application home page.
 */

@Controller
@Transactional
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
//	@InitBinder
//	public void initBinder(WebDataBinder webDataBinder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		dateFormat.setLenient(false);
//		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}	
//	
	@RequestMapping(value = "/usuario/formUsuario", method = RequestMethod.GET)
	public String formUsuario() {
		return "pages/formUsuario";
	}
	
	@RequestMapping(value = "/usuario/listUsuarios", method = RequestMethod.GET)
	public String listUsuarios() {
		return "pages/listUsuario";
	}

	

	@RequestMapping(value = "/usuario/gravarUsuario", method = RequestMethod.POST)
	public String gravar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("index");
		usuarioService.gravar(usuario);
		
		return "redirect:/usuario/formUsuario";
	}
	
	
	
}
