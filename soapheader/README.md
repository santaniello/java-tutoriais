# Soap Header

## How to consume a WebService that uses Ws-Security Authentication (UsernameToken) – OWSM – Oracle Service Bus (OSB) 

###File: MainPost.java – This is a main class to make a request
 
```java
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

```   

###File: WSSecurityHeaderSOAPHandler.java – This is a handler responsible for creating the header authentication.

```java
package br.com.globus.main;


import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class WSSecurityHeaderSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	private static final String TOKEN_KEY = "Token";
	private static final String SHORT_CODE = "ShortCode";	
	private static final String METHOD_NAME = "NomeMetodo";

	private static final String SOAP_ELEMENT_SECURITY = "AutenticacaoWebService";
	private static final String NAMESPACE_SECURITY = "http://tempuri.org/";
	private static final String PREFIX_SECURITY = "tem";
	
	private String tokenValue;
	private String shortCodeValue;
	private String methodNameValue;
	
	public WSSecurityHeaderSOAPHandler(String token, String shortCode, String methodName){
		this.tokenValue = token;
		this.shortCodeValue = shortCode;
		this.methodNameValue = methodName;
	}
	
	public boolean handleMessage(SOAPMessageContext soapMessageContext) {
				
		Boolean outboundProperty = (Boolean) soapMessageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			
			try {
				SOAPEnvelope soapEnvelope = soapMessageContext.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = soapEnvelope.getHeader();
				if (header == null) {
					header = soapEnvelope.addHeader();
				}
						
				// Accessing the node <tem:AutenticacaoWebService>
				SOAPElement soapElementSecurityHeader = header.addChildElement(
						SOAP_ELEMENT_SECURITY, 
						PREFIX_SECURITY,
						NAMESPACE_SECURITY
				);
				
				// Accessing the node  <tem:Token>
				SOAPElement soapElementUsernameToken = soapElementSecurityHeader.addChildElement(
						TOKEN_KEY, 
						PREFIX_SECURITY
				);
				
				// Informing the token value
				soapElementUsernameToken.addTextNode(tokenValue);
			
				// Accessing the node  <tem:ShortCode>
				SOAPElement soapElementShortCode = soapElementSecurityHeader.addChildElement(
						SHORT_CODE,
						PREFIX_SECURITY
				);
				
				// Informing the short code value
				soapElementShortCode.addTextNode(shortCodeValue);
				
				// Accessing the node  <tem:NomeMetodo>
				SOAPElement soapElementMethodNameValue = soapElementSecurityHeader.addChildElement(
						METHOD_NAME,
						PREFIX_SECURITY
				);	
						
				// // Informing the name of method value
				soapElementMethodNameValue.addTextNode(methodNameValue);
							
			} catch (Exception e) {
				throw new RuntimeException("Error on wsSecurityHandler: " + e.getMessage());
			}
		}
		return true;
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
}
```

### Xml Request: This is the payload request that Java Client request to the server.

```xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tem="http://tempuri.org/">
   <soapenv:Header>
      <tem:AutenticacaoWebService>
         <!--Optional:-->
         <tem:Token>NzM0NzY7NjQyOzM1Ng==</tem:Token>
         <tem:ShortCode>1025</tem:ShortCode>
         <!--Optional:-->
         <tem:NomeMetodo>IntegracaoVelocimetroWs.asmx</tem:NomeMetodo>
      </tem:AutenticacaoWebService>
   </soapenv:Header>
   <soapenv:Body>
      <tem:AtualizarVelocimetro>
         <!--Optional:-->
         <tem:prefixo>C3214</tem:prefixo>
         <!--Optional:-->
         <tem:placa>ELW-4386</tem:placa>
         <tem:dataHora>2016-07-19T15:17:00</tem:dataHora>
         <tem:hodometro>4583</tem:hodometro>
      </tem:AtualizarVelocimetro>
   </soapenv:Body>
</soapenv:Envelope>

```

### This project is based in: https://victorjabur.com/2014/11/03/how-to-consume-a-webservice-that-uses-ws-security-authentication-usernametoken-owsm-oracle-service-bus-osb/	

