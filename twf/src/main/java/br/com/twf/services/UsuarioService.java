package br.com.twf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.twf.model.beans.Usuario;
import br.com.twf.model.repositories.UsuarioDAO;
import br.com.twf.model.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioDao;
	
	
	public void gravar(Usuario usuario){
		try {
			usuarioDao.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
