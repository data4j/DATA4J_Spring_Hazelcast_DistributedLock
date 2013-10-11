package org.data4j.main;

import org.data4j.operator.DistributedListDemonstrator;
import org.data4j.operator.DistributedListLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class starts the application
 * 
 * @author data4j.org
 * @since 17 Sept 2013
 * @version 1.0.0
 *
 */
public class Application {
	
	/**
     * Starts the application
     *
     * @param  String[] args
	 *
     */
	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DistributedListLoader distributedListLoader = context.getBean(DistributedListLoader.class);		
		distributedListLoader.load();
		
		Thread distListDmnsThread = new Thread(context.getBean(DistributedListDemonstrator.class));
		distListDmnsThread.start();
	}	
}
