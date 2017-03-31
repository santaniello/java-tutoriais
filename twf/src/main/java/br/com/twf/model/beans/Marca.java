package br.com.twf.model.beans;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.twf.deserializer.DateStringToCalendarDeserializer;
import br.com.twf.enumerations.Status;
import br.com.twf.serializer.CalendarToDateStringSerializer;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
		
	@JsonDeserialize(using = DateStringToCalendarDeserializer.class)
	@JsonSerialize(using = CalendarToDateStringSerializer.class)
	@Column(name = "dataCadastro", nullable = false)
	private Calendar dataCadastro;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status status;

	public Marca() {}
	
	public Marca(long id, String nome, Calendar dataCadastro, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
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
		Marca other = (Marca) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nome=" + nome + ", dataCadastro=" + dataCadastro + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
		
}
