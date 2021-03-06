
package com.unf.edu.wsat.billpay;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BillPayServiceATImplService", targetNamespace = "http://billpay.wsat.edu.unf.com/", wsdlLocation = "http://localhost:8080/BillPay/BillPayServiceATImpl?wsdl")
public class BillPayServiceATImplService
    extends Service
{

    private final static URL BILLPAYSERVICEATIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException BILLPAYSERVICEATIMPLSERVICE_EXCEPTION;
    private final static QName BILLPAYSERVICEATIMPLSERVICE_QNAME = new QName("http://billpay.wsat.edu.unf.com/", "BillPayServiceATImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BillPay/BillPayServiceATImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BILLPAYSERVICEATIMPLSERVICE_WSDL_LOCATION = url;
        BILLPAYSERVICEATIMPLSERVICE_EXCEPTION = e;
    }

    public BillPayServiceATImplService() {
        super(__getWsdlLocation(), BILLPAYSERVICEATIMPLSERVICE_QNAME);
    }

    public BillPayServiceATImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BILLPAYSERVICEATIMPLSERVICE_QNAME, features);
    }

    public BillPayServiceATImplService(URL wsdlLocation) {
        super(wsdlLocation, BILLPAYSERVICEATIMPLSERVICE_QNAME);
    }

    public BillPayServiceATImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BILLPAYSERVICEATIMPLSERVICE_QNAME, features);
    }

    public BillPayServiceATImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BillPayServiceATImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BillPayServiceAT
     */
    @WebEndpoint(name = "BillPayServiceATImplPort")
    public BillPayServiceAT getBillPayServiceATImplPort() {
        return super.getPort(new QName("http://billpay.wsat.edu.unf.com/", "BillPayServiceATImplPort"), BillPayServiceAT.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BillPayServiceAT
     */
    @WebEndpoint(name = "BillPayServiceATImplPort")
    public BillPayServiceAT getBillPayServiceATImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://billpay.wsat.edu.unf.com/", "BillPayServiceATImplPort"), BillPayServiceAT.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BILLPAYSERVICEATIMPLSERVICE_EXCEPTION!= null) {
            throw BILLPAYSERVICEATIMPLSERVICE_EXCEPTION;
        }
        return BILLPAYSERVICEATIMPLSERVICE_WSDL_LOCATION;
    }

}
