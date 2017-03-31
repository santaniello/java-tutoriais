package br.com.twf.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.twf.exceptions.InvalidRequestException;
	
/**
 * O Controller {@code MyExceptionHandler} vai capturar a exception {@code InvalidRequestException} 
 * e gerar um objeto Json customizado envolvendo as classes {@code ErrorResource} e {@code FieldErrorResource}
 * com os erros do BeanValidation. 
 *
 * @see InvalidRequestException
 * @see ErrorResource
 * @see FieldErrorResource
 * @see <a href="http://springinpractice.com/2013/10/09/generating-json-error-object-responses-with-spring-web-mvc">http://springinpractice.com</a>
 */	
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
    
	/**
	 * Método responsável por monitorar as exceções informadas no {@code @ExceptionHandler} e montar o JSON com 
	 * erros do BeanValidation.
	 *
	 * @param exception Exceção que será capturada para ser tratada.
	 * @param request  requisação em que ocorreu a exception (atual).
	 * @return Obejto JSON serializado com os erros do BeanValidation
	 * 
	 * @see InvalidRequestException
	 * @see ErrorResource
	 * @see FieldErrorResource
	 */
    @ExceptionHandler({ InvalidRequestException.class })  
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException exception, WebRequest request) {
        InvalidRequestException ire = (InvalidRequestException) exception;
        List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

        // obtendo os campos com erro e montando uma lista...
        List<FieldError> fieldErrors = ire.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            FieldErrorResource fieldErrorResource = new FieldErrorResource();
            fieldErrorResource.setResource(fieldError.getObjectName());
            fieldErrorResource.setField(fieldError.getField());
            fieldErrorResource.setCode(fieldError.getCode());
            fieldErrorResource.setMessage(fieldError.getDefaultMessage());
            fieldErrorResources.add(fieldErrorResource);
        }

        // Criando a nossa classe que será serializada...
        ErrorResource error = new ErrorResource("InvalidRequest", ire.getMessage());
        error.setFieldErrors(fieldErrorResources);

        // montando o header....
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Estamos devolvendo o erro Unprocessable Entity (HTTP 422)
        return handleExceptionInternal(exception, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}