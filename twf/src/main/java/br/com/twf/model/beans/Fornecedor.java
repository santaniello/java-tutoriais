package br.com.twf.model.beans;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.twf.deserializer.DateStringToCalendarDeserializer;
import br.com.twf.enumerations.Status;
import br.com.twf.enumerations.TipoFornecedor;
import br.com.twf.serializer.CalendarToDateStringSerializer;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "nome", length = 60, nullable = false)
	private String nome;
	
	@Column(name = "cnpj", length = 30, nullable = true)
	private String cnpj;
	
	@JsonDeserialize(using = DateStringToCalendarDeserializer.class)
	@JsonSerialize(using = CalendarToDateStringSerializer.class)
	@Column(name = "dataCadastro", nullable = false)
	private Calendar dataCadastro;
	
	@Column(name = "cep", length = 9, nullable = false)
	private String cep;
	
	@Column(name = "logradouro", length = 200, nullable = false)
	private String logradouro;
	
	@Column(name = "bairro", length = 150, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;

	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;

	@Column(name = "telefoneComercial", length = 20, nullable = false)
	private String telefoneComercial;

	@Column(name = "email", length = 100, nullable = true)
	private String email;
	
	@Column(name = "site", length = 200, nullable = true)
	private String site;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status status;
    

//	@OneToMany(fetch = FetchType.EAGER,cascade={CascadeType.REFRESH, CascadeType.MERGE},mappedBy="fornecedor")
//	private Collection<Cotacao> cotacoes;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipoFornecedor", length = 20, nullable = false)
	private TipoFornecedor tipoFornecedor;

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

//	public Collection<Cotacao> getCotacoes() {
//		return cotacoes;
//	}
//
//	public void setCotacoes(Collection<Cotacao> cotacoes) {
//		this.cotacoes = cotacoes;
//	}

	public TipoFornecedor getTipoFornecedor() {
		return tipoFornecedor;
	}

	public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}
	
   
		
}
