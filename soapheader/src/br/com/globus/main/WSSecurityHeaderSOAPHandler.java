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
						
				// Acessa o nó <tem:AutenticacaoWebService>
				SOAPElement soapElementSecurityHeader = header.addChildElement(
						SOAP_ELEMENT_SECURITY, 
						PREFIX_SECURITY,
						NAMESPACE_SECURITY
				);
				
				// Acessa o nó  <tem:Token>
				SOAPElement soapElementUsernameToken = soapElementSecurityHeader.addChildElement(
						TOKEN_KEY, 
						PREFIX_SECURITY
				);
				
				// Informa o Valor do token
				soapElementUsernameToken.addTextNode(tokenValue);
			
				// Acessa o nó  <tem:ShortCode>
				SOAPElement soapElementShortCode = soapElementSecurityHeader.addChildElement(
						SHORT_CODE,
						PREFIX_SECURITY
				);
				
				// Informa o Valor do Short Code
				soapElementShortCode.addTextNode(shortCodeValue);
				
				// Acessa o nó  <tem:NomeMetodo>
				SOAPElement soapElementMethodNameValue = soapElementSecurityHeader.addChildElement(
						METHOD_NAME,
						PREFIX_SECURITY
				);	
						
				// Informa o Valor do nome do método
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