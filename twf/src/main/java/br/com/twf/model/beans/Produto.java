package br.com.twf.model.beans;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.twf.deserializer.DateStringToCalendarDeserializer;
import br.com.twf.enumerations.Status;
import br.com.twf.serializer.CalendarToDateStringSerializer;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "idMarca" , foreignKey = @ForeignKey(name="FK_produto_marca"))	
	private Marca marca;
		
	@Column(name = "estoqueMinimo",  nullable = false)
	private int estoqueMinimo;
	
	@Column(name = "estoqueAtual",  nullable = false)
	private int estoqueAtual;
	
	@Column(name = "estoqueMaximo",  nullable = false)
	private int estoqueMaximo;
	
	@Column(name = "precoVenda",  nullable = false)
	private BigDecimal precoVenda;
	
	@JsonDeserialize(using = DateStringToCalendarDeserializer.class)
	@JsonSerialize(using = CalendarToDateStringSerializer.class)
	@Column(name = "dataCadastro", nullable = false)
	private Calendar dataCadastro;
		
	@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
	@JoinColumn(name = "idCategoria" , foreignKey = @ForeignKey(name="FK_produto_categoria"))	
	private CategoriaProduto categoriaProduto;
	
	
//	@OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE},mappedBy="produto")
//	private Collection<Cotacao> cotacoes;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status status;
	
	public Produto() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

//	public Collection<Cotacao> getCotacoes() {
//		return cotacoes;
//	}
//
//	public void setCotacoes(Collection<Cotacao> cotacoes) {
//		this.cotacoes = cotacoes;
//	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
		
}
