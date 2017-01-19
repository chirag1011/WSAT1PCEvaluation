package com.unf.edu.wsat.balanceinquiry;

import com.arjuna.wst.Aborted;
import com.arjuna.wst.Durable2PCParticipant;
import com.arjuna.wst.Prepared;
import com.arjuna.wst.SystemException;
import com.arjuna.wst.Vote;
import com.arjuna.wst.WrongStateException;
import com.arjuna.wst._1PCParticipant;

public class BalanceInquiryParticipant implements Durable2PCParticipant,_1PCParticipant
{
	private String txID;
	private MockBalanceInquiryManager mockBalanceInquiryManager = MockBalanceInquiryManager.getSingletonInstance();
	public BalanceInquiryParticipant(String txID){
		this.txID = txID;
	}

	@Override
	public Vote prepare() throws WrongStateException, SystemException {
		// Log the event and invoke the prepare operation
        // on the back-end logic.
        System.out.println("[SERVICE] Prepare called on participant, about to prepare the back-end resource");
        boolean success = mockBalanceInquiryManager.prepare(txID);

        // Map the return value from
        // the business logic to the appropriate Vote type.
        if (success) {
            System.out.println("[SERVICE] back-end resource prepared, participant votes prepared");
            return new Prepared();
        } else {
            System.out.println("[SERVICE] back-end resource failed to prepare, participant votes aborted");
            return new Aborted();
        }
		
	}

	@Override
	public void commit() throws WrongStateException, SystemException {
		System.out.println("BalanceInquiryParticipant [SERVICE]---------------transaction is about to commit-------------");
		mockBalanceInquiryManager.commit(txID);
		
	}

	@Override
	public void rollback() throws WrongStateException, SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unknown() throws SystemException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error() throws SystemException {
		// TODO Auto-generated method stub
		
	}

}
