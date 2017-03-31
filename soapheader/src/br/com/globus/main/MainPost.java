package br.com.globus.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import br.com.globus.service.ArrayOfString;
import br.com.globus.service.IntegracaoVelocimetroWS;
import br.com.globus.service.IntegracaoVelocimetroWSSoap;

public class MainPost {

	
    public static void main(String[] args) {
    	 
        try {        	
        	IntegracaoVelocimetroWS ws = new IntegracaoVelocimetroWS();
        	IntegracaoVelocimetroWSSoap soap = ws.getIntegracaoVelocimetroWSSoap();
        	
            // TODO: Get token WsCore
            String tokenValueGetWs = "NzM0NzY7NjQyOzM1Ng==";
            String shortCode = "1025";
            String methodName = "IntegracaoVelocimetroWs.asmx";
            
            BindingProvider bindingProvider = (BindingProvider) soap;
            @SuppressWarnings("rawtypes")
            List<Handler> handlerChain = new ArrayList<Handler>();
            
            handlerChain.add(new WSSecurityHeaderSOAPHandler( tokenValueGetWs, shortCode, methodName ));
                      
            bindingProvider.getBinding().setHandlerChain(handlerChain);
 
            ArrayOfString listReturn = soap.atualizarVelocimetro("C4094", "DJC-1755", DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-05-11T07:46:00"), new BigDecimal(210));
            
            List<String>  listReturn2 = listReturn.getString();
            
            for (String valor : listReturn2) {
				System.out.println( valor );
			}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }	
	
}
