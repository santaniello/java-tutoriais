package br.com.twf.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.twf.enumerations.Status;
import br.com.twf.model.beans.Cliente;

@Component
public interface ClienteService extends Service<Cliente> {	
	List<Cliente> findByStatus(Status status);
}
