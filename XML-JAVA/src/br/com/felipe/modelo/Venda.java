package br.com.felipe.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Informamos ao JAXB que essa classe representa um XML
@XmlAccessorType(XmlAccessType.FIELD) // Informamos ao JAXB que o método de acesso é através dos campos...
public class Venda {

	private String formaDePagamento;
	
	@XmlElementWrapper(name="produtos") // Quanto temos uma lista, precisamos informar a tag que engloba a lista...
	@XmlElement(name="produto") // E precisamos informar a tag que corresponde a cada elemento da lista ...
	private List<Produto> produtos;
	
	
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		return "Venda [formaDePagamento=" + formaDePagamento + ",\n produtos=" + produtos + "]";
	}
	
	
}
