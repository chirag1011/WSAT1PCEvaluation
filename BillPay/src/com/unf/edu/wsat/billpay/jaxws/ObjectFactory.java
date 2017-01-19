
package com.unf.edu.wsat.billpay.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.unf.edu.wsat.billpay.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BillPayException_QNAME = new QName("http://jaxws.billpay.wsat.edu.unf.com/", "BillPayException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unf.edu.wsat.billpay.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BillPayException }
     * 
     */
    public BillPayException createBillPayException() {
        return new BillPayException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BillPayException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.billpay.wsat.edu.unf.com/", name = "BillPayException")
    public JAXBElement<BillPayException> createBillPayException(BillPayException value) {
        return new JAXBElement<BillPayException>(_BillPayException_QNAME, BillPayException.class, null, value);
    }

}
