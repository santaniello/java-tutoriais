package br.com.twf.model.beans;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.twf.deserializer.DateStringToCalendarDeserializer;
import br.com.twf.serializer.CalendarToDateStringSerializer;

@Entity
@IdClass(CotacaoProdutoId.class)
public class Cotacao {
	
	@Id
	@ManyToOne
	//@JsonBackReference
	@JoinColumn(name = "idProduto",referencedColumnName="id")
	private Produto produto;
	 
	@Id
	@ManyToOne
	//@JsonBackReference
	@JoinColumn(name = "idFornecedor",referencedColumnName="id")
	private Fornecedor fornecedor;
	
	@Column(name = "custo", length = 30, nullable = true)
	private BigDecimal custo;
			
	@JsonDeserialize(using = DateStringToCalendarDeserializer.class)
	@JsonSerialize(using = CalendarToDateStringSerializer.class)
	@Column(name = "dataAtualizacao", nullable = false)
	private Calendar dataAtualizacao;
	
	public Cotacao() {}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Cotacao [produto=" + produto + ", fornecedor=" + fornecedor + ", custo=" + custo + ", dataAtualizacao="
				+ dataAtualizacao + "]";
	}
	
	
	
	
				
}
