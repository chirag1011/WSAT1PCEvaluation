package com.unf.edu.wsat.billpay.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.unf.edu.wsat.billpay.BillPayException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BillPayServiceAT {

	@WebMethod
    public void paybillamount(String protocolType,long amount) throws BillPayException;
}
