package com.unf.edu.wsat.billpay;

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
import com.unf.edu.wsat.billpay.jaxws.BillPayServiceAT;

@WebService(endpointInterface = "com.unf.edu.wsat.billpay.jaxws.BillPayServiceAT")
@HandlerChain(file = "/context-handlers.xml", name = "Context Handlers")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BillPayServiceATImpl implements BillPayServiceAT{
	private MockBillPayManager mockBillPayManager = MockBillPayManager.getSingletonInstance();
	String transactionId;
	@Override
	public void paybillamount(String protocolType, long amount)
			throws BillPayException {
		try {
			System.out.println("BillPayServiceATImpl.paybillamount()--------------Start");
			transactionId = UserTransactionFactory.userTransaction().toString();
			BillPayParticipant billPayParticipant = new BillPayParticipant(transactionId);
			TransactionManager transactionManager = TransactionManagerFactory.transactionManager();
			if("2PC".equalsIgnoreCase(protocolType)){
				System.out.println("[SERVICE] Enlisting a Durable2PC participant into the AT");
				transactionManager.enlistForDurableTwoPhase(billPayParticipant, "BillPayServiceAT:" + UUID.randomUUID());
			}
			else if("1PC".equalsIgnoreCase(protocolType))
				transactionManager.enlistForOnePhase(billPayParticipant, "BillPayServiceAT:" + UUID.randomUUID());
		} catch (WrongStateException e) {
			System.out.println("BillPayServiceATImpl.paybillamount()-----WrongStateException-------"+e);
			e.printStackTrace();
		} catch (UnknownTransactionException e) {
			System.out.println("BillPayServiceATImpl.paybillamount()------UnknownTransactionException------"+e);
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("BillPayServiceATImpl.paybillamount()-----SystemException-------"+e);
			e.printStackTrace();
		}
		System.out.println("[SERVICE] Invoking the back-end business logic");
		mockBillPayManager.paybill(transactionId,amount);
		
	}

}
