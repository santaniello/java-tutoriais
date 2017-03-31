package br.com.twf.deserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * A classe {@code DateStringToCalendarDeserializer} e´responsavel por receber um objeto do JSON e converte-lo para um 
 * objeto do tipo Calendar. É importante notar que precisa-se extender de {@code JsonDeserializer<Classe para qual queremos realizar a conversão>}. 
 * OBS: A ferramenta responsável pela serialização e deserialização de objetos usadas nesse projeto é o Jackson 
 *
 * @see <a href="https://brunozambiazi.wordpress.com/2015/08/15/working-with-json-in-java/">https://brunozambiazi.wordpress.com</a>
 */	
public class DateStringToCalendarDeserializer extends JsonDeserializer<Calendar> {
	@Override
	public Calendar deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Calendar calendar = null;
		try {
			String formatted = p.getValueAsString();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");			
			calendar = Calendar.getInstance();
			calendar.setTime(sdf.parse(formatted));
		} catch (Exception e) {
			throw new IOException(e);			
		}
			return calendar;		
	}
}
		