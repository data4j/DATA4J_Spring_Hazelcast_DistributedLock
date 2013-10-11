package org.data4j.cache.srv;

import org.data4j.customer.Customer;

import com.hazelcast.core.IList;

/**
 * A new IDistributedListService Interface is created for service layer to expose cache functionality.
 *  
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public interface IDistributedListService {

	/**
     * Adds Customer entries to customerList
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	boolean addToDistributedList(Customer customer);

	/**
     * Removes Customer entries from customerList
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	boolean removeFromDistributedList(Customer customer);

	/**
     * Gets Customer List
     *
     * @return IList customerList
     */
	IList<Customer> getCustomerList();
}
