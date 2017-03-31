package br.com.felipe.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorParaHTML {
   public static void main(String[] args) throws Exception{
	   // Carrega os documentos na mem�ria...
	   InputStream xsl = new FileInputStream("src/xmlParaHTML.xsl");
	   InputStream xml = new FileInputStream("src/vendas.xml");
	   
	   StreamSource xslSource = new StreamSource(xsl);
	   StreamSource xmlSource = new StreamSource(xml);
	   // Passamos o arquivo que n�s queremos que seja criado...
	   StreamResult saida = new StreamResult("src/vendas.html");
	   
	   // Cria��o da classe que far� a transforma��o do arquivo xml para HTML ...
	   Transformer transformer = TransformerFactory.newInstance().newTransformer(xslSource);
	   // Transforma��o do arquivo ...
	   transformer.transform(xmlSource, saida);
	   
	   
   }
}
