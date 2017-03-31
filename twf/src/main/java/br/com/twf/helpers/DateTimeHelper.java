package br.com.twf.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeHelper {
	
	private static final Logger logger = LoggerFactory.getLogger(DateTimeHelper.class);

	public static Calendar fromStringToCalendar(String date){
		if(date != null){
			Date dataRetorno = null;
			Calendar cal =  null;
						 
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			 
			try {
			    dataRetorno =  sdf.parse(date);
				cal = Calendar.getInstance();
				cal.setTime(dataRetorno);			
			 }catch (ParseException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			 }			 
		  return cal;	
		}
		return null;
	}
	
	public static String fromDateToString(Calendar calendar){
		return calendar != null ? fromDateToString(calendar) : "null";
	}	
	
	public static String fromDateTimeToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return date != null ? formatter.format(date) : "null";
	}
	
	public static String fromDateTimeToString(Calendar calendar){
		return calendar != null ? fromDateTimeToString(calendar.getTime()) : "null";
	}

	public static String fromDateToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return date != null ? formatter.format(date) : "null";
	}
	
	public static String toTimeAsString(Calendar calendar){
		return calendar != null ? toTimeAsString(calendar) : "null";
	}
	
		
}