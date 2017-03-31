package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//Usando JAXB para serializar (caso eu queira usar Xtream � so tirar essas anota��es)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // Falando que todos os campos devem ser serializados por padr�o
public class Produto {

	private double preco;
	private long id;
	private String nome;
	private int quantidade;
	
	// JAXB pede um construtor sem argumentos...
	public Produto() {
	}
	
	public Produto(long id, String nome, double preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public double getPrecoTotal() {
		return quantidade * preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
