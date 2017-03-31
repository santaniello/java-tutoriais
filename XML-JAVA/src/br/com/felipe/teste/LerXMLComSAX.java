package br.com.felipe.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.felipe.handlers.ProdutosHandler;

/* 
 *  Utilizando SAX para trabalhar com XML ...
 *  
 *  Explicação: Essa abordagem trata eventos do nosso xml.   
 *  Foi utlizada a classe ProdutosHandler que é utilizada para manipular os eventos do nosso documento xml.
 *  Essa abordagem é melhor quando precisamos ler apenas partes do documento xml...
 *  
 */


public class LerXMLComSAX {
   public static void main(String[] args) throws SAXException, IOException {
	   XMLReader leitor = XMLReaderFactory.createXMLReader();
	   ProdutosHandler logica = new ProdutosHandler();
	   leitor.setContentHandler(logica);
	      
	   InputStream ips = new FileInputStream("src/vendas.xml");
	   InputSource is = new InputSource(ips);
	   leitor.parse(is);
	   
	   System.out.println(logica.getListaProdutos());
	   
   }
}
