package com.unf.edu.wsat.balanceinquiry.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.Handler;

import com.arjuna.mw.wst11.UserTransaction;
import com.arjuna.mw.wst11.UserTransactionFactory;
import com.arjuna.mw.wst11.client.JaxWSHeaderContextProcessor;
import com.unf.edu.wsat.balanceinquiry.BalanceInquiryAT;
import com.unf.edu.wsat.balanceinquiry.BalanceInquiryATImplService;

/**
 * @author ChiragR
 */

/**
 * Servlet implementation class BalanceInquiryServlet
 */
@WebServlet("/BalanceInquiryServlet")
public class BalanceInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@WebServiceRef(value = BalanceInquiryATImplService.class)
    private BalanceInquiryAT client;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BindingProvider bindingProvider = (BindingProvider) client;
		@SuppressWarnings("rawtypes")
		List<Handler> handlers = new ArrayList<Handler>(1);
        handlers.add(new JaxWSHeaderContextProcessor());
        bindingProvider.getBinding().setHandlerChain(handlers);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        long amount = 0;
        UserTransaction ut = UserTransactionFactory.userTransaction();
        long startTime = 0;
        long stopTime = 0;
        try {
        	
        	System.out
                    .println("[CLIENT] Beginning Atomic Transaction (All calls to Web services that support WS-AT wil be included in this transaction)");
            
            
            for(int i=0;i<1;i++){
            	startTime = 0;
            	stopTime = 0;
            	startTime = System.currentTimeMillis();
            	//out.write("<p>=================Start=========================</p>");	
            ut.begin();
            System.out.println("[CLIENT] invoking makeBooking() on WS");
            amount = client.getBalance("2PC");
            //amount = client.getBalance("1PC");
            System.out.println("[CLIENT] committing Atomic Transaction (This will cause the AT to complete successfully)");
            ut.commit();
            stopTime = System.currentTimeMillis();
            System.out.println("WSATSimpleServletClient.doGet()--------EXECUTION TIME---------:"+this.measureExecutionTime(startTime, stopTime));
            
            //out.write("<p>Balance Amount:::$"+amount+"</p>");
            //out.write("<p><h4>Exection Time:"+this.measureExecutionTime(startTime, stopTime)+"</h4></p>");
            out.write(""+this.measureExecutionTime(startTime, stopTime));
            out.write("<br/>");
           // out.write("<p>=================End=========================</p>");	
            }
            
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rollbackIfActive(ut);
            //client.reset();
        }
        
        out.write("<h1>Balance Inquiry servlet</h1>");

        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private long measureExecutionTime(long startTime, long stopTime){
    	
    	return stopTime - startTime;
    }
	
	 private void rollbackIfActive(UserTransaction ut) {
	        try {
	            ut.rollback();
	        } catch (Throwable th2) {
	            // do nothing, not active
	        }
	    }


}
