package br.com.felipe.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.felipe.modelo.Produto;

public class LerXMLComDom {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Criando um documento xml na memória para trabalhar com ele.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Força o nosso programa a usar a validação do arquivo xsd.
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
        
        
        // Obtendo o atributo moeda do xml
        Element venda = document.getDocumentElement();
        String moeda = venda.getAttribute("moeda");
        System.out.println(moeda);
        
        
        
        // Retornando o valor de uma tag especifica do documento xml (retorna uma lista)
        NodeList produtos = document.getElementsByTagName("produto");
        
        for(int x = 0; x < produtos.getLength(); x++){
	        
	        Element produto = (Element) produtos.item(x);
	        
	        String nome  = produto.getElementsByTagName("nome").item(0).getTextContent();
	        double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
	        
	        Produto prod = new Produto(nome, preco);
	        System.out.println(prod);
        }
		
	}
}
