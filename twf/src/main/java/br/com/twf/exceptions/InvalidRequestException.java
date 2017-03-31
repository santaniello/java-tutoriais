package br.com.twf.exceptions;

import java.lang.reflect.Constructor;

import org.springframework.validation.Errors;

import br.com.twf.validation.ErrorResource;
import br.com.twf.validation.FieldErrorResource;

/**
 * A classe {@code InvalidRequestException} é uma exception criada para ser disparada quando houverem erros
 * referentes ao BeanValidation. 
 *
 */	
@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    /**
	 * Construtor criado para receber a mensagem de erro e os erros do BeanValidation
	 * @param messade Uma {@code String} contendo uma mensagem de erro.
	 * @param errors  Um objeto do tipo {@code BindingResult} contendo os erros do BeanValidation  
	 * 
	 */   
    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { 
    	return errors; 
    }
}