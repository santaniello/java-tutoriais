package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

@Path("carrinhos")
public class CarrinhoResource {
	
	/* Serialiazação com Xtream*/

//	@Path("{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public String busca(@PathParam("id") long id ) {
//		Carrinho carrinho = new CarrinhoDAO().busca(id);
//		return carrinho.toXML();
//	}
//	
//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//	public Response adiciona(String conteudo) {
//	    Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
//	    new CarrinhoDAO().adiciona(carrinho);
//	   // Pega o item que acabamos de inserir...
//	    URI uri = URI.create("/carrinhos/" + carrinho.getId());
//	    // Retorna o Status code da requisição
//	    // O método created retorna 201 se o objeto(recurso) foi criado com sucesso
//	    // .buid transforma a resposta em uma response...
//	    return Response.created(uri).build();
//	}
//    
//    @Path("{id}/produtos/{produtoId}")
//    @DELETE
//    public Response remove(@PathParam("id") long id, @PathParam("produtoId") long produtoId){
//    	Carrinho carrinho = new CarrinhoDAO().busca(id);
//    	carrinho.remove(produtoId);
//    	return Response.ok().build();
//    }
//	
//    @Path("{id}/produtos/{produtoId}/quantidade")
//    @PUT
//    public Response alteraProduto(String conteudo, @PathParam("id") long id, @PathParam("produtoId") long produtoId){
//    	Carrinho carrinho = new CarrinhoDAO().busca(id);
//    	Produto produto = (Produto)new XStream().fromXML(conteudo);
//    	carrinho.trocaQuantidade(produto);
//    	return Response.ok().build();
//    }
//	
    
	/* Serialiazação com JAXB (Serializador padrão do java)*/
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Carrinho busca(@PathParam("id") long id ) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho;
	}
	
    @POST
    @Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(Carrinho carrinho) {
	    new CarrinhoDAO().adiciona(carrinho);
	   // Pega o item que acabamos de inserir...
	    URI uri = URI.create("/carrinhos/" + carrinho.getId());
	    // Retorna o Status code da requisição
	    // O método created retorna 201 se o objeto(recurso) foi criado com sucesso
	    // .buid transforma a resposta em uma response...
	    return Response.created(uri).build();
	}
    
    @Path("{id}/produtos/{produtoId}")
    @DELETE
    public Response remove(@PathParam("id") long id, @PathParam("produtoId") long produtoId){
    	Carrinho carrinho = new CarrinhoDAO().busca(id);
    	carrinho.remove(produtoId);
    	return Response.ok().build();
    }
	
    @Path("{id}/produtos/{produtoId}/quantidade")
    @PUT
    public Response alteraProduto(Produto produto, @PathParam("id") long id, @PathParam("produtoId") long produtoId){
    	Carrinho carrinho = new CarrinhoDAO().busca(id);
    	carrinho.trocaQuantidade(produto);
    	return Response.ok().build();
    }
	
    
	/**
	 * Método para retornar um JSON ao invés do XML...
	 */
		
//	@Path("{id}")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String busca(@PathParam("id") long id ) {
//		Carrinho carrinho = new CarrinhoDAO().busca(id);
//		return carrinho.toJSON();
//	}
	
	
}
