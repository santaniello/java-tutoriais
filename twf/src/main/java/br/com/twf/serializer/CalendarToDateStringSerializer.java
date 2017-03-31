package br.com.twf.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.twf.exceptions.InvalidRequestException;
import br.com.twf.validation.ErrorResource;
import br.com.twf.validation.FieldErrorResource;

/**
 * A classe {@code CalendarToDateStringSerializer} e´responsavel por receber um objeto do tipo Calendar como parâmetro 
 * e realizar a conversão e serialização do objeto para o formato dd/mm/yyyy. É importante notar que precisa-se extender
 * de {@code JsonSerializer<Classe a ser convertida>}. 
 * OBS: A ferramenta responsável pela serialização e deserialização de objetos usadas nesse projeto é o Jackson 
 *
 * @see <a href="https://brunozambiazi.wordpress.com/2015/08/15/working-with-json-in-java/">https://brunozambiazi.wordpress.com</a>
 */	
public class CalendarToDateStringSerializer extends JsonSerializer<Calendar> {
	 @Override
	    public void serialize(Calendar value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
	        if (value != null) {        
	            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            String formatted = sdf.format(value.getTime());
	            gen.writeString(formatted);
	        }
	    }
	
}
