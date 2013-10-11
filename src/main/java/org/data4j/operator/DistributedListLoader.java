package org.data4j.operator;

import org.data4j.cache.srv.IDistributedListService;
import org.data4j.customer.Customer;

/**
 * DistributedSetLoader Class loads Customers to customerList.
 * 
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public class DistributedListLoader {
	
	private	IDistributedListService distributedListService;
	
	/**
     * Loads Customer Items to customerList.
     *
     */
	public void load() {
		Customer firstCustomer = new Customer();
		firstCustomer.setId("1");
		firstCustomer.setName("Name1");
		firstCustomer.setSurname("Surname1");
		
		Customer secondCustomer = new Customer();
		secondCustomer.setId("1");
		secondCustomer.setName("Name1");
		secondCustomer.setSurname("Surname1");
		
		Customer thirdCustomer = new Customer();
		thirdCustomer.setId("3");
		thirdCustomer.setName("Name3");
		thirdCustomer.setSurname("Surname3");
		
		distributedListService.addToDistributedList(firstCustomer);
		distributedListService.addToDistributedList(secondCustomer);
		distributedListService.addToDistributedList(thirdCustomer);
		
	}

	public void setDistributedListService(IDistributedListService distributedListService) {
		this.distributedListService = distributedListService;
	}
	
}
