package com.unf.edu.wsat.balanceinquiry;

import java.util.UUID;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.arjuna.mw.wst11.TransactionManager;
import com.arjuna.mw.wst11.TransactionManagerFactory;
import com.arjuna.mw.wst11.UserTransactionFactory;
import com.arjuna.wst.SystemException;
import com.arjuna.wst.UnknownTransactionException;
import com.arjuna.wst.WrongStateException;

@WebService(endpointInterface = "com.unf.edu.wsat.balanceinquiry.BalanceInquiryAT")
@HandlerChain(file = "/context-handlers.xml", name = "Context Handlers")
@SOAPBinding(style = SOAPBinding.Style.RPC)


public class BalanceInquiryATImpl implements BalanceInquiryAT{

	private MockBalanceInquiryManager balanceInquiryManager = MockBalanceInquiryManager.getSingletonInstance();
	String transactionId;
	@Override
	public long getBalance(String protocolType) throws BalanceInquiryException {
		
		System.out.println("BalanceInquiryATImpl.getBalance()-----------------In getBalance");
		try {
			
			transactionId = UserTransactionFactory.userTransaction().toString();
			BalanceInquiryParticipant balanceInquiryParticipant  = new BalanceInquiryParticipant(transactionId);
			TransactionManager transactionManager = TransactionManagerFactory.transactionManager();
			
			System.out.println("BalanceInquiryATImpl.getBalance()");
			if("2PC".equalsIgnoreCase(protocolType)){
				System.out.println("[SERVICE] Enlisting a Durable2PC participant into the AT");
				transactionManager.enlistForDurableTwoPhase(balanceInquiryParticipant, "balanceInquiryServiceAT:" + UUID.randomUUID());
			}
			else if("1PC".equalsIgnoreCase(protocolType))
				transactionManager.enlistForOnePhase(balanceInquiryParticipant, "balanceInquiryServiceAT:" + UUID.randomUUID());
		} catch (WrongStateException e) {
			System.out.println("BalanceInquiryATImpl.getBalance()====WrongStateException======"+e);
			e.printStackTrace();
		} catch (UnknownTransactionException e) {
			System.out.println("BalanceInquiryATImpl.getBalance()====UnknownTransactionException======"+e);
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("BalanceInquiryATImpl.getBalance()====SystemException======"+e);
			e.printStackTrace();
		}
		
		// invoke the backend business logic:
        System.out.println("[SERVICE] Invoking the back-end business logic");
        System.out.println("BalanceInquiryATImpl.getBalance()---------"+balanceInquiryManager.getBalance(transactionId));
        return balanceInquiryManager.getBalance(transactionId); 
        
		
	}

	@Override
	public long generateBalanceAmount() {
		
		return 0;
	}

}
