package br.com.felipe.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.felipe.modelo.Produto;

/*
 * Consulta em XML utilizando o XPath
 * 
 * 
 * */


public class ConsultaXMLComXpath {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
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
        
       
        /* O XPath entende o xml como dietórios, dentro da tag vendas temos a 
         tag produtos e dentro de produtos temos a tag produto que é o elemento que
          queremos pesquisar.
          
          Para realizarmos uma pesquisa, podemos realizar a mesma de diversas formas tais como:
          
          Passando o indice do elemento que queremos:
          
          String exp = "/venda/produtos/produto[2]";
          
          Pesquisando através de uma caracteristica:
          
          String exp = "/venda/produtos/produto[nome='Livro de xml']";
          
          Usando funções de apoio:
          
          String exp = "/venda/produtos/produto[contains(nome,'Livro')]";
          
          e etc ...
        */  
               
        String exp = "/venda/produtos/produto[2]";
        XPath path = XPathFactory.newInstance().newXPath();
        
        /*Compilamos a nossa expressão */
        XPathExpression expression = path.compile(exp);
        
        /* aqui realizamos a nossa pesquisa no documento xml, o segundo parametro 
         * da função é uma das constantes do Xpath e informamos que o mesmo vai retornar 
         * uma lista do tipo NODESET */
        NodeList produtos = (NodeList)expression.evaluate(document, XPathConstants.NODESET);
        
        for(int x = 0; x < produtos.getLength(); x++){
	        
	        Element produto = (Element) produtos.item(x);
	        
	        String nome  = produto.getElementsByTagName("nome").item(0).getTextContent();
	        double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
	        
	        Produto prod = new Produto(nome, preco);
	        System.out.println(prod);
        }
		
	}
}
