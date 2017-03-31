package br.com.felipe.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import br.com.felipe.modelo.Produto;


/* Utilizando STAX para trabalhar com XML ...
 * Ele é muito parecido com o SAX a única coisa que muda é a forma de trabalhar com os eventos do xml.
 * Lendo o XML através de eventos ... 
 * 
 *  */


public class LerXMLComSTAX {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/vendas.xml");
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
	    Produto produto = null;
	    List<Produto> listaProdutos = new ArrayList<Produto>();
	    
	    /* vai ficar lendo o arquivo enquanto houver um próximo evento... */
	    while(eventos.hasNext()){
	    	
	    	XMLEvent evento = eventos.nextEvent();
	    		    	
	    	/* Quando um elemento iniciar ele vai pegar o nome do elemento (nesse caso a tag produto) e verificar se é igual a produto ... */
	    	if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")){
	    		 produto = new Produto();
	    	/* Quando um elemento iniciar ele vai pegar o nome do elemento (nesse caso a tag produto) e verificar se é igual a nome ... */
	 	    }else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")){
	    		evento = eventos.nextEvent(); // vai para o próximo evento ...
	    		String conteudo = evento.asCharacters().getData();
	    		produto.setNome(conteudo);
	    	/* Quando um elemento iniciar ele vai pegar o nome do elemento (nesse caso a tag produto) e verificar se é igual a preco ... */
		    }else if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")){
	    		evento = eventos.nextEvent();
	    		String conteudo = evento.asCharacters().getData();
	    		double preco = Double.parseDouble(conteudo);
	    		produto.setPreco(preco);
	    	/* quando o elemento produto terminar ele adiciona o mesmo na lista */	
	    	}else if(evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")){
	    		listaProdutos.add(produto);
	    	}
	    }
	    	    
	    System.out.println(listaProdutos);
	    
	}
    
	
	
	
}
