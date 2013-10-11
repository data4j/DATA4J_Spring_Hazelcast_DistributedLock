package org.data4j.operator;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.data4j.cache.srv.IDistributedListService;
import org.data4j.customer.Customer;

/**
 * DistributedListDemonstrator Class demonstrates Customers from customerList.
 * 
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public class DistributedListDemonstrator implements Runnable {

	private static final Logger logger = Logger.getLogger(DistributedListDemonstrator.class);
	
	private	IDistributedListService distributedListService;
	
	@Override
	public void run() {
		try {			
			while(true) {
				demonstrate();
				Thread.sleep(60_000);
			}
		} catch (InterruptedException e) {
			logger.error(e);
		}
	}
	
	/**
     * Demonstrates Customer Entries via distributedList.
	 *
     */
	public void demonstrate()  {	
		Iterator<Customer> customerIterator = distributedListService.getCustomerList().iterator();
		while(customerIterator.hasNext()) {
			logger.debug("Customer Entries => " + customerIterator.next());
		}				
	}

	public void setDistributedListService(IDistributedListService distributedListService) {
		this.distributedListService = distributedListService;
	}
	
}
