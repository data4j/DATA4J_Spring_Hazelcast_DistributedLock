Hazelcast Distributed Data Structures : DistributedLock

java.util.concurrent.locks.Lock Interface came with JDK 5 and provides thread synchronization mechanism and more extensive locking operations than can be obtained using synchronized methods and statements. Before JDK 5, the only mechanisms for coordinating access to shared data were synchronized and volatile.

The methods of Lock Interface :

- void lock() : Acquires the lock.
- void lockInterruptibly() : Acquires the lock unless the current thread is interrupted.
- boolean tryLock() : Acquires the lock only if it is free at the time of invocation.
- boolean tryLock(long timeout, TimeUnit timeUnit) : Acquires the lock if it is free within the given waiting time and the current thread has not been interrupted.
- void unlock() : Releases the lock.
- Condition newCondition() : Returns a new Condition instance that is bound to this Lock instance

Its basic implementation is the following :

    Lock lock = new ReentrantLock();
    try {
        lock.lock();
 
        //locked block
        
    } finally {
        lock.unlock();
    }
	
com.hazelcast.core.ILock Interface is distributed implementation of Lock Interface. When a member leaves from the cluster, all the locks acquired by this member will be released so that these locks can be available for live members immediately.

Its basic implementation is the following :

    ILock lock = getHazelcastLocalInstance().getLock(customer);    
    try {
        lock.lock();
        result = customerList.add(customer);
    } finally {
        lock.unlock();
    }
	
This article shows how to implement Hazelcast-DistributedLock Feature.

Used Technologies : JDK 1.7.0_40, Spring 3.2.3, Hazelcast 3.0-RC1 and Maven 3.0.4