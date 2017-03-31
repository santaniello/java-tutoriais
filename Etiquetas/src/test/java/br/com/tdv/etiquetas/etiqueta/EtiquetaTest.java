package br.com.tdv.etiquetas.etiqueta;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.tdv.etiquetas.etiqueta.Etiqueta;
import br.com.tdv.etiquetas.etiqueta.ImpressaoEtiquetas;
import junit.framework.Assert;

public class EtiquetaTest {

	private FileInputStream stream;
	private InputStreamReader reader;
	private BufferedReader br;
	
	@Before
	public void beforeMethod() throws IOException {
		stream = new FileInputStream( ImpressaoEtiquetas.PATH_ETIQUETA );
		reader = new InputStreamReader(stream);
		br = new BufferedReader(reader);
	}
		
	@Test
	public void testParaGravarArquivoDaEtiqueta() throws IOException {

		
		Etiqueta etiqueta = new Etiqueta();
		etiqueta.setCodigoBarra("01721573605002460016300010121045959"); 
		etiqueta.setDescricaoCodigoBarra("01721573 - 60500246001630 - 001 - 012 - 1045959");
		etiqueta.setCnpj("60500246001630");
		etiqueta.setArmazem("0E1-Sao Bernardo do Cam");
		etiqueta.setEmbalagem("1045959");
		etiqueta.setPo("4502286497000");
		etiqueta.setPeso("1.215,000");
		etiqueta.setRemetente("GOODYEAR DO BRASIL PRODS. DE");
		etiqueta.setUsuario("jsantos teste e");
		etiqueta.setNotaFiscal("01721573");
		
		
		Etiqueta etiqueta2 = new Etiqueta();
		etiqueta2.setCodigoBarra("01721573605002460016300010121045959");
		etiqueta2.setDescricaoCodigoBarra("01721573 - 60500246001630 - 001 - 012 - 1045959");
		etiqueta2.setCnpj("60500246001630");
		etiqueta2.setArmazem("CARAJAS");
		etiqueta2.setEmbalagem("1045959");
		etiqueta2.setPo("4502286497000");
		etiqueta2.setPeso("1.215,000");
		etiqueta2.setRemetente("GOODYEAR DO BRASIL PRODS. DE B");
		etiqueta2.setUsuario("jsantos");
		etiqueta2.setNotaFiscal("01721573");
		ImpressaoEtiquetas imprimeEtiqueta = new ImpressaoEtiquetas();
		imprimeEtiqueta.gravaArquivo(etiqueta2);
					
	}
	
	@Test
	public void testQuantidadeLinhas() throws IOException {
		String linha = br.readLine();
		int count = 0;
		while(linha != null) {
		   count++;
		   linha = br.readLine();
		}
		Assert.assertEquals("O arquivo deve ter obrigatóriamente 28 linhas", 28, count);
	}
	
	@Test
	public void testLinha13CodigoBarra() throws IOException {
		String linha = br.readLine();
		boolean achouLetraC = false;
		
		int count = 0;
		int tamanhoLinha = 0;
		while(linha != null) {
			count++;
			if( count == 13 ) {
				tamanhoLinha = linha.length();
				achouLetraC = linha.indexOf("C") == 15;				
			  }			
			linha = br.readLine();
		}		
		Assert.assertEquals("A linha 13/CodigoBarra deve ter obrigatóriamente 51 caracteres", 51, tamanhoLinha);
		Assert.assertTrue("A presença da string C é obrigatória no código de barras", achouLetraC );
	}
	
	@Test
	public void testLinha14ValorCodigoBarra() throws IOException{
		String linha = br.readLine();
		int count = 0;
		int tamanhoLinha = 0;
		while(linha != null) {
			count++;
			if( count == 14 ) {
			   tamanhoLinha = linha.length();	
			}			
			linha = br.readLine();
		}    			
    	Assert.assertEquals("A linha 14/ValorCodigoBarra deve ter obrigatóriamente 62 caracteres", 62, tamanhoLinha);
  	}
	
	@Test
	public void testLinha15CodigoBarra() throws IOException {
		String linha = br.readLine();
		boolean achouLetraC = false;
		
		int count = 0;
		int tamanhoLinha = 0;
		while(linha != null) {
			count++;
			if( count == 15 ) {
				tamanhoLinha = linha.length();
				achouLetraC = linha.indexOf("C") == 15;				
			}			
			linha = br.readLine();
		}		
		Assert.assertEquals("A linha 15/CodigoBarra deve ter obrigatóriamente 51 caracteres", 51, tamanhoLinha);
		Assert.assertTrue("A presença da string C é obrigatória no código de barras", achouLetraC );
	}	
	
	@Test
	public void testLinha16CodigoBarra() throws IOException {
		String linha = br.readLine();
		boolean achouLetraC = false;
		int count = 0;
		int tamanhoLinha = 0;
		while(linha != null) {
			count++;
			if( count == 16 ) {
				tamanhoLinha = linha.length();
				achouLetraC = linha.indexOf("C") == 15;				
			}			
			linha = br.readLine();
		}		
		Assert.assertEquals("A linha 16/CodigoBarra deve ter obrigatóriamente 51 caracteres", 51, tamanhoLinha);
		Assert.assertTrue("A presença da string C é obrigatória no código de barras", achouLetraC );   	
	}
	
	
	@Test
	public void testLinha17CNPJ () throws IOException {
		String linha = br.readLine();
		int count = 0;
		int tamanhoLinha = 0;
		
		while(linha != null) {
			count++;
			if(count == 17) {
				tamanhoLinha = linha.length();
			}	
			linha = br.readLine();
		}		
	    Assert.assertEquals("A linha 17/CNPJ deve ter obrigatóriamente 33 caracteres", 33, tamanhoLinha);
	}
	
	
	@Test
	public void testLinha18Armazem() throws IOException {
		String linha = br.readLine();
		int count = 0;
		boolean tamanhoLinha = false;
		
		while(linha != null) {
			count++;
			if(count == 18) {
			   tamanhoLinha = linha.length() <= 38;
			}	
			linha = br.readLine();
		}		
	    Assert.assertTrue("A linha 18/Armazem deve ter obrigatóriamente 38 caracteres", tamanhoLinha);		
	}
		
	@Test
	public void testLinha19EmbalagemPO() throws IOException {
		String linha = br.readLine();
		boolean tamanhoLinha = false;
		
		int count = 0;
		while(linha != null) {
			count++;
			if( count == 19 ) {
			    tamanhoLinha = linha.length() <= 48;
			}			
			linha = br.readLine();
		}		
		Assert.assertTrue("A embalagem deve ter obrigatóriamente no máximo 48 caracteres ",  tamanhoLinha);		
	}
		
	@Test
	public void testLinha21Remetente() throws IOException {
		String linha = br.readLine();
		int count = 0;
		boolean tamanhoAlemDoLimite = false;
		
		while(linha != null) {
			count++;
			if(count == 21) {
				tamanhoAlemDoLimite = linha.length() <= 43;
			}	
			linha = br.readLine();
		}		
	    Assert.assertTrue("A linha 21/Remetente deve ter no maximo 43 caracteres", tamanhoAlemDoLimite);
    }
	
    @Test
    public void testLinha22Usuario() throws IOException {
    	String linha = br.readLine();
		int count = 0;
		boolean tamanhoAlemDoLimite = false;
		
		while(linha != null) {
			count++;
			if(count == 22) {
				tamanhoAlemDoLimite = linha.length() <= 53;
			}	
			linha = br.readLine();
		}		
	   Assert.assertTrue("A linha 22/Usuario deve ter no maximo 53 caracteres", tamanhoAlemDoLimite);    	
    }
    
    @Test
    public void testLinha23CodigoBarra() throws IOException {
    	String linha = br.readLine();
		int count = 0;
		int tamanhoLinha = 0;
		while(linha != null) {
			count++;
			if( count == 23 ) {
				tamanhoLinha = linha.length();
			}			
			linha = br.readLine();
		}		
		Assert.assertEquals("A linha 23/CodigoBarra deve ter obrigatóriamente 50 caracteres", 50, tamanhoLinha);
    }

	@Test
	public void testeDeImpressaoDeEtiquetas() throws InterruptedException {
		ImpressaoEtiquetas etiqueta = new ImpressaoEtiquetas();
		etiqueta.imprimeEtiqueta( "c:\\etiqueta.prn" );
	}
	   
	@After
	public void afterMethod() throws IOException {
		br.close();
		reader.close();
		stream.close();
	}
	

		
}
