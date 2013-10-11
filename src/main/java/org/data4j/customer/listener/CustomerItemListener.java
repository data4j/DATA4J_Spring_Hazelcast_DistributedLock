package org.data4j.customer.listener;

import org.apache.log4j.Logger;
import org.data4j.customer.Customer;

import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

/**
 * CustomerItemListener Class listens items changes on Customer List object.
 * 
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public class CustomerItemListener implements ItemListener<Customer> {

	private static final Logger logger = Logger.getLogger(CustomerItemListener.class);
	
	/**
     * Invoked when an item is added.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void itemAdded(ItemEvent<Customer> ie) {
		logger.debug("Item is added. Member : " + ie.getMember() + ", Item : "+ie.getItem());
	}

	/**
     * Invoked when an item is removed.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void itemRemoved(ItemEvent<Customer> ie) {
		logger.debug("Item is removed. Member : " + ie.getMember() + ", Item : "+ie.getItem());
	}

}
