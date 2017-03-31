package br.com.twf.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;
import br.com.twf.model.beans.Marca;

@Component
public interface MarcaService extends Service<Marca>  {	
	
}
