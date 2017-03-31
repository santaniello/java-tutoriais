package br.com.twf.services;

import java.util.List;


public interface Service<T> {

	public T save(T object);	
	public T findById(long id);	
	public List<T> findAll();	
	public void delete(T object);
}
