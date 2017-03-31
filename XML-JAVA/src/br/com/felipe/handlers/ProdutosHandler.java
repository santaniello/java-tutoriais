package br.com.felipe.handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.felipe.modelo.Produto;

/*
 * Utilizando SAX para trabalhar com XML ...
 * Classe que vai tratar os eventos do xml...
 * Precisamos extender da classe DefaultHandler
 * */

public class ProdutosHandler extends DefaultHandler{

	private Produto produto;
	private StringBuilder conteudo;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	
	//M�todo acionado quando uma tag do xml � acionada (aberta)...
	//qName � o nome da tag que esta sendo lida 
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("produto")){
			produto = new Produto();
		}
		conteudo = new StringBuilder();
	} 
		
	// M�todo acionado quando o conteudo da tag � lida (Ele l� caractere por caractere e � por isso que recebe um array de char[])...
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// precisamos de um StringBuilder para concatenar o conteudo da tag visto que o mesmo pode conter espa�os...
	    conteudo.append(new String(ch,start,length));
	}
	
	// m�todo acionado quando uma tag � encerrada...
	//qName � o nome da tag que esta sendo lida 
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
	    if(qName.equals("produto")){
	    	listaProdutos.add(produto);
	    }else if (qName.equals("nome")){
	    	produto.setNome(conteudo.toString());
	    }else if(qName.equals("preco")){
	    	produto.setPreco(Double.parseDouble(conteudo.toString()));
	    }
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}	
	
}
