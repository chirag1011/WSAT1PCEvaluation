
package com.unf.edu.wsat.billpay;


/**
 * 
 * @author ChiragR
 *
 */
public class MockBillPayManager {

    // The singleton instance of this class.
    private static MockBillPayManager singletonInstance;

   
    /**
     * Accessor to obtain the singleton restaurant manager instance.
     * 
     * @return the singleton RestaurantManager instance.
     */
    public synchronized static MockBillPayManager getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new MockBillPayManager();
        }

        return singletonInstance;
    }

    /**
     * Make a booking with the restaurant.
     * 
     * @param txID The transaction identifier
     */
    public synchronized void paybill(Object txID,long amount) {
        System.out.println("[SERVICE] paybill called on backend resource.");
       
    }

    /**
     * Prepare local state changes for the supplied transaction. This method should persist any required information to ensure
     * that it can undo (rollback) or make permanent (commit) the work done inside this transaction, when told to do so.
     * 
     * @param txID The transaction identifier
     * @return true on success, false otherwise
     */
    public boolean prepare(Object txID) {
        System.out.println("[SERVICE] prepare called on backend resource.");
        return true;
    }

    /**
     * commit local state changes for the supplied transaction
     * 
     * @param txID The transaction identifier
     */
    public void commit(Object txID) {
        System.out.println("[SERVICE] commit called on backend resource.");
        
    }

    /**
     * roll back local state changes for the supplied transaction
     * 
     * @param txID The transaction identifier
     */
    public void rollback(Object txID) {
        System.out.println("[SERVICE] rollback called on backend resource.");
    }

    
    
}
