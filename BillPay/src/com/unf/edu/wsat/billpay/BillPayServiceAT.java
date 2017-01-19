
package com.unf.edu.wsat.billpay;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import com.unf.edu.wsat.billpay.jaxws.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BillPayServiceAT", targetNamespace = "http://jaxws.billpay.wsat.edu.unf.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BillPayServiceAT {


    /**
     * 
     * @param arg1
     * @param arg0
     * @throws BillPayException
     */
    @WebMethod
    public void paybillamount(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        long arg1)
        throws BillPayException
    ;

}