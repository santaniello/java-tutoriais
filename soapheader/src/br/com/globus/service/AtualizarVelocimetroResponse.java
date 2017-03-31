
package br.com.globus.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AtualizarVelocimetroResult" type="{http://tempuri.org/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "atualizarVelocimetroResult"
})
@XmlRootElement(name = "AtualizarVelocimetroResponse")
public class AtualizarVelocimetroResponse {

    @XmlElement(name = "AtualizarVelocimetroResult")
    protected ArrayOfString atualizarVelocimetroResult;

    /**
     * Obtém o valor da propriedade atualizarVelocimetroResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAtualizarVelocimetroResult() {
        return atualizarVelocimetroResult;
    }

    /**
     * Define o valor da propriedade atualizarVelocimetroResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setAtualizarVelocimetroResult(ArrayOfString value) {
        this.atualizarVelocimetroResult = value;
    }

}
