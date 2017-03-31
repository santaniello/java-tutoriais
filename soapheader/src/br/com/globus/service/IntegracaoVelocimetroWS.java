
package br.com.globus.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IntegracaoVelocimetroWS", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://192.168.9.56:8082/GlobusMaisBGM/IntegracaoVelocimetroWS.asmx?wsdl")
public class IntegracaoVelocimetroWS
    extends Service
{

    private final static URL INTEGRACAOVELOCIMETROWS_WSDL_LOCATION;
    private final static WebServiceException INTEGRACAOVELOCIMETROWS_EXCEPTION;
    private final static QName INTEGRACAOVELOCIMETROWS_QNAME = new QName("http://tempuri.org/", "IntegracaoVelocimetroWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.9.56:8082/GlobusMaisBGM/IntegracaoVelocimetroWS.asmx?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INTEGRACAOVELOCIMETROWS_WSDL_LOCATION = url;
        INTEGRACAOVELOCIMETROWS_EXCEPTION = e;
    }

    public IntegracaoVelocimetroWS() {
        super(__getWsdlLocation(), INTEGRACAOVELOCIMETROWS_QNAME);
    }

    public IntegracaoVelocimetroWS(WebServiceFeature... features) {
        super(__getWsdlLocation(), INTEGRACAOVELOCIMETROWS_QNAME, features);
    }

    public IntegracaoVelocimetroWS(URL wsdlLocation) {
        super(wsdlLocation, INTEGRACAOVELOCIMETROWS_QNAME);
    }

    public IntegracaoVelocimetroWS(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INTEGRACAOVELOCIMETROWS_QNAME, features);
    }

    public IntegracaoVelocimetroWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IntegracaoVelocimetroWS(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IntegracaoVelocimetroWSSoap
     */
    @WebEndpoint(name = "IntegracaoVelocimetroWSSoap")
    public IntegracaoVelocimetroWSSoap getIntegracaoVelocimetroWSSoap() {
        return super.getPort(new QName("http://tempuri.org/", "IntegracaoVelocimetroWSSoap"), IntegracaoVelocimetroWSSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IntegracaoVelocimetroWSSoap
     */
    @WebEndpoint(name = "IntegracaoVelocimetroWSSoap")
    public IntegracaoVelocimetroWSSoap getIntegracaoVelocimetroWSSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "IntegracaoVelocimetroWSSoap"), IntegracaoVelocimetroWSSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INTEGRACAOVELOCIMETROWS_EXCEPTION!= null) {
            throw INTEGRACAOVELOCIMETROWS_EXCEPTION;
        }
        return INTEGRACAOVELOCIMETROWS_WSDL_LOCATION;
    }

}