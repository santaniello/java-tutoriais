package br.com.twf.model.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.twf.deserializer.DateStringToCalendarDeserializer;
import br.com.twf.enumerations.Status;
import br.com.twf.serializer.CalendarToDateStringSerializer;

@Entity
public class Cliente {
	
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

	@Column(name = "telefoneComercial", length = 20, nullable = true)
	private String telefoneComercial;

	@Column(name = "telefoneCelular", length = 20, nullable = true)
 	private String telefoneCelular;
	
	@Column(name = "email", length = 100, nullable = true)
	private String email;
	
	@Column(name = "site", length = 200, nullable = true)
	private String site;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status status;
		
	public Cliente() {}

	public Cliente(long id, String nome, String cnpj, Calendar dataCadastro, String cep, String logradouro,
			String bairro, String cidade, String uf, String numero, String telefoneComercial, String telefoneCelular,
			String email, String site, Status status) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.dataCadastro = dataCadastro;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.numero = numero;
		this.telefoneComercial = telefoneComercial;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.site = site;
		this.status = status;
	}

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

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", dataCadastro=" + dataCadastro + ", cep="
				+ cep + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf
				+ ", numero=" + numero + ", telefoneComercial=" + telefoneComercial + ", telefoneCelular="
				+ telefoneCelular + ", email=" + email + ", site=" + site + ", status=" + status + "]";
	}
			
}
