package br.com.felipe.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.felipe.modelo.Produto;
import br.com.felipe.modelo.Venda;

/* Utilizando JAXB para trabalhar com XML ...
 * Precisamos criar uma classe que vai representar o nosso XML (Nesse caso a classe venda)...
 * Precisamos fazer o mapeamento necessário na classe para que o JAXB saiba que essa classe representa um XML...
 * 
 */


public class XMLComJAXB {
    public static void main(String[] args) throws JAXBException {
	
    	// Processo que que transforma um XML em um objeto (Nessa caso objeto Vendas)...
    	JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
    	//XMLparaObjeto(jaxbContext);
    	objetoParaXML(jaxbContext);
    	
    	
    	
    	
    }

	private static void objetoParaXML(JAXBContext jaxbContext) throws JAXBException {
		// classe que converte o objeto em xml ...
		Marshaller marshaller = jaxbContext.createMarshaller();
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(new Produto("Livro php", 59.90));
		listaProdutos.add(new Produto("Livro Ruby", 29.90));
		listaProdutos.add(new Produto("Livro Pyton", 39.90));
		listaProdutos.add(new Produto("Livro CSS", 69.90));
		venda.setProdutos(listaProdutos);
		
		// Usaremos a classe StringWriter apenas para imprimir o xml em forma de String no console, porém poderiamos muito bem gravar em um arquivo fisico...
		StringWriter writer = new StringWriter();
		// Gerando xml ....
		marshaller.marshal(venda, writer);
		System.out.println(writer.toString());
		
		
	}

	private static void XMLparaObjeto(JAXBContext jaxbContext) throws JAXBException {
		// Classe responsavel por realizar a conversão do objeto ...
    	Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
    	Venda venda  = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
    	System.out.println(venda);
    	
		
	}
}
