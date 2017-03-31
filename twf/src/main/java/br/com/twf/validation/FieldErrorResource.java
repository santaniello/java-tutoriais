package br.com.twf.validation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe que irá receber as informações a respeito dos erros de cada campo (Field) de uma classe e irá armazer as informações
 * como: o nome do campo que apresentou o erro, o código do erro e a mensagem de erro e etc... 
 *
 */	

@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldErrorResource {
    private String resource;
    private String field;
    private String code;
    private String message;

    public String getResource() { return resource; }

    public void setResource(String resource) { this.resource = resource; }

    public String getField() { return field; }

    public void setField(String field) { this.field = field; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}