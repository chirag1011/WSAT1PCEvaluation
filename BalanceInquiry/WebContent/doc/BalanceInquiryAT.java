package com.unf.edu.wsat.balanceinquiry.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.unf.edu.wsat.balanceinquiry.BalanceInquiryException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BalanceInquiryAT {

	@WebMethod
    public void getBalance(String protocolType) throws BalanceInquiryException;
	
	@WebMethod
	public long generateBalanceAmount();
	
}
