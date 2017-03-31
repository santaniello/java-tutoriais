package br.com.alura.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;



public class ClienteTeste {
	
	
	private  HttpServer server;
	private  WebTarget target;
	private Client client;

	/**
	 * Inicia o Servidor antes de cada Teste
	 */
	@Before
	public void startaServidor() {
		
		server   = Servidor.inicializaServidor();
		/*Criação de um filtro para debugar o que acontece entre o meu cliente e o servidor */
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFilter());
		// Registrando o filtro
		this.client = ClientBuilder.newClient(config);
	    target = client.target("http://localhost:8095");
		
	}
	
	/* Teste com XStream*/
	
//	@Test
//	public void testeQueBuscarOCarrinhoTrazoCarrinhoEsperado(){
//		String conteudo = target.path("/carrinhos/1").request().get(String.class);
//        Carrinho carrinho = (Carrinho)new XStream().fromXML(conteudo);
//        Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
//    }
//
//	@Test
//	public void testaQueSuportaNovosCarrinhos(){
//		/* Cria um carrinho normal */
//		Carrinho carrinho = new Carrinho();
//		carrinho.adiciona(new Produto(314,"Microfone",31,1));
//		carrinho.setRua("Rua Vergueiro 3185");
//		carrinho.setCidade("São Paulo");
//		/* Converte o carrinho para XML */
//		String xml = carrinho.toXML();
//		/* O entity é o xml + o context (MediaType.APPLICATION_XML) para informar que é um xml */
//		Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);
//		/* Aqui pegamos o status code do Post que fizemos */
//		Response response = target.path("/carrinhos").request().post(entity);
//		/* Testamos se o post foi realizado com sucesso */
//		Assert.assertEquals(201, response.getStatus());
//		/* Aqui pegamos o Location que acabamos de inserir http://localhost:8095/carrinhos/{algum id} */
//		String location = response.getHeaderString("Location");
//		/* Aqui pegamos o XML que acabamos de inserir */
//		String conteudo = this.client.target(location).request().get(String.class);
//		/* Verificamos se tem a palavara microfone */
//		Assert.assertTrue(conteudo.contains("Microfone"));
//		
//	}
	
	/* Teste com JAXB */
	
	@Test
	public void testeQueBuscarOCarrinhoTrazoCarrinhoEsperado(){
		Carrinho carrinho = target.path("/carrinhos/1").request().get(Carrinho.class);
        Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
    }

	@Test
	public void testaQueSuportaNovosCarrinhos(){
		/* Cria um carrinho normal */
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(new Produto(314,"Microfone",31,1));
		carrinho.setRua("Rua Vergueiro 3185");
		carrinho.setCidade("São Paulo");
		
		/* O entity é o xml + o context (MediaType.APPLICATION_XML) para informar que é um xml */
		Entity<Carrinho> entity = Entity.entity(carrinho, MediaType.APPLICATION_XML);
		/* Aqui pegamos o status code do Post que fizemos */
		Response response = target.path("/carrinhos").request().post(entity);
		/* Testamos se o post foi realizado com sucesso */
		Assert.assertEquals(201, response.getStatus());
		/* Aqui pegamos o Location que acabamos de inserir http://localhost:8095/carrinhos/{algum id} */
		String location = response.getHeaderString("Location");
		/* Aqui pegamos o XML que acabamos de inserir */
	    Carrinho carrinhoCarregado  = this.client.target(location).request().get(Carrinho.class);
		/* Verificamos se tem a palavara microfone */
		Assert.assertEquals("Microfone",carrinhoCarregado.getProdutos().get(0).getNome());
		
		
	}

	/**
	 * 	
	 * Finaliza o Servidor antes de cada Teste
	 */
 
	@After
	public void mataServidor() {
		server.stop();
	}

	
	
}
