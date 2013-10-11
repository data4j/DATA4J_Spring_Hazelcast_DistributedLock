package org.data4j.cache.srv;

import org.data4j.customer.Customer;
import org.data4j.customer.listener.CustomerItemListener;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.ILock;

/**
 * DistributedListService Class is implementation of IDistributedListService Interface.
 * 
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public class DistributedListService implements IDistributedListService {

	private Hazelcast hazelcast;
	private String hazelcastInstanceName;
	private IList<Customer> customerList;
	
	/**
     * Constructor of DistributedListService
     *
     * @param IList customerList
	 *
     */
	public DistributedListService(IList<Customer> customerList) {
		setCustomerList(customerList);
		customerList.addItemListener(new CustomerItemListener(), true);
	}
	
	@Override
	public boolean addToDistributedList(Customer customer) {
		boolean result;
		ILock lock = getHazelcastLocalInstance().getLock(customer);
		lock.lock();
		try {
			result = customerList.add(customer);
		} finally {
		    lock.unlock();
		}		
		
		return result;
	}

	@Override
	public boolean removeFromDistributedList(Customer customer) {
		boolean result;
		ILock lock = getHazelcastLocalInstance().getLock(customer);
		lock.lock();
		try {
			result = customerList.remove(customer);
		} finally {
		    lock.unlock();
		}		
		
		return result;
	}
	
	/**
     * Gets Customer List
     *
     * @return IList customerList
     */
	public IList<Customer> getCustomerList() {
		return customerList;
	}

	/**
     * Gets Hazelcast Local Instance
     *
     * @return HazelcastInstance
     */
	@SuppressWarnings("static-access")
	private HazelcastInstance getHazelcastLocalInstance() {
        HazelcastInstance instance = hazelcast.getHazelcastInstanceByName(hazelcastInstanceName);
        return instance;
    }

	public void setCustomerList(IList<Customer> customerList) {
		this.customerList = customerList;
	}

	public void setHazelcast(Hazelcast hazelcast) {
		this.hazelcast = hazelcast;
	}

	public void setHazelcastInstanceName(String hazelcastInstanceName) {
		this.hazelcastInstanceName = hazelcastInstanceName;
	}
	
}
