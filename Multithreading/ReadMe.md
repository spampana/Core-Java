Benefits of Multithreading
==========================
1. Higher throughput, or the ability to process more units of information in a given amount of time. (This assumes that the throughput ‘cost’ associated with dealing with multiple threads is lower than the efficiency it creates. This is usually, but not always, the case.)

2. More responsive applications that provide user seamless experiences and the illusion of multitasking. For example, an app’s UI will still be functional and responsive even while IO activity is happening in the background of an image processing app.

3. More efficient utilization of resources. Generally speaking, thread creation is less ‘costly’ compared to creating a brand new process. Web servers that use threads instead of creating a new process when fielding web requests consume far fewer resources.

Problems with Multithreading
============================
1. More difficult to find bugs. The reasons for a process not executing successfully may now be external to the process itself. The execution order and prioritization of threads can’t always be predicted and is up to the operating system itself.

2. Higher cost of code maintenance, since the code has now had multiple levels of complexity added to it.

3. More demand on the system. The creation of each thread consumes additional memory, CPU cycles for book-keeping and time spent on switching ‘contexts.’ Additionally, keep in mind if a processor is going to run 5 threads simultaneously it will also need to keep information about each of those processes around and accessible while the other ones execute, requiring more registers.



Executor
========

Executor is an interface that represents an object that executes provided tasks.

It depends on the particular implementation , if the task should be run on a new or current thread.

Hence, using this interface, we can decouple the task execution flow from the actual task execution mechanism.

Point to note here is that if the executor can’t accept the task for execution, it will throw RejectedExecutionException.


public interface Executor {
    /**
     * Executes the given command at some time in the future.  The command
     * may execute in a new thread, in a pooled thread, or in the calling
     * thread, at the discretion of the {@code Executor} implementation.
     *
     * @param command the runnable task
     * @throws RejectedExecutionException if this task cannot be
     * accepted for execution
     * @throws NullPointerException if command is null
     */
     
     void execute(Runnable command);
}


ExecutorService
===============

ExecutorService is an interface. 

The Java ExecutorService is a construct that allows you to pass a task to be executed by a thread asynchronously. 
The executor service creates and maintains a reusable pool of threads for executing submitted tasks. 
The service also manages a queue, which is used when there are more tasks than the number of threads in the pool and there is a need to queue up tasks until there is a free thread available to execute the task.

There are two ways to instantiate a Thread Pool Executor. You can either directly instantiate it using one of its constructor overloads or you can use one of the factory methods in the Executors class.

Directly instantiating a ThreadPoolExecutor
-------------------------------------------

ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)

//Directly instantiating a ThreadPoolExecutor with 10 threads, a keepAliveTime of 0 milliseconds, and a LinkedBlockingQueue:
ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


Parameters:

corePool size: 
The core pool size is the minimum number of threads(alive) that should be kept in the pool

maxPool size : 
The max pool size is the maximum number of workers that can be in the pool.
If the max pool size has already been reached and the work queue is full, then the next task will be rejected. 

workQueue :
The work queue is used to queue up tasks for the available worker threads.
The queue can be bounded or unbounded.
For bounded queues, setting the queue size is an important exercise, as it affects how the worker pool grows and when you start running into RejectedExecutionExceptions.

keepAliveTime :
If a thread pool grows to the max size, how does it shrink back to the core size? That's where the keepAliveTime comes in.
If the current number of worker threads exceeds the core pool size and a keepAliveTime is set, then worker threads are shut down when there is no more work to do until the number of worker threads is back to the core pool size; a thread will wait for work for the keepAlive time, and when that is exceeded and no work arrives, it will shut down.

threadFactory :
Most times, using the Default ThreadFactory is sufficient. The default thread factory creates worker threads that have a normal priority and are not daemon threads. 
It also gives the threads a name with the format: "pool-{poolNumber}-thread-{threadNumber}". If you want to customize any of these attributes, such as the thread name or priority, then you should provide your own threadFactory implementation. 

rejectedExecutionHandler :
I mentioned that for pools with a bounded work queue, task rejections occur when the queue is full and no more workers can be added. You can configure a handler to run when such a rejection occurs. 
These handlers are called "Policies". 
By default, the AbortPolicy is used, which throws a RejectedExecutionException. 
You can choose to use another Policy such as the 
a)DiscardPolicy, which simply discards the task silently; 
b)CallerRunsPolicy, which executes the task on the calling thread instead of one of the worker threads; or any another policy implementation you create.


Side note 1: 
You can set allowCoreThreadTimeOut to true on your ThreadPoolExecutor instance, and if you do so, then not only do workers threads that exceed the core pool size get shut down on idle, but core worker threads also get shut down on idle. By default, this is set to false.

Side note 2: 
If your worker threads acquire and maintain expensive resources and only release those resources on shutdown, then it becomes important to optimally configure your keepAlive time. A keepAlive time of 0 ms means that your workers never shut down after they are created, unless the executor service itself is shut down.

Using Factory methods
---------------------

//A thread pool with a fixed number of threads.
ExecutorService executor = Executors.newFixedThreadPool(10);

//A thread pool with only one thread. So all the submitted tasks will be executed sequentially.
ExecutorService executor = Executors.newSingleThreadExecutor();

//A thread pool that creates as many threads it needs to execute the task in parallel. 
ExecutorService executor = Executors.newCachedThreadPool();

//which can schedule tasks to run after a delay, or to execute repeatedly with a fixed interval of time in between each execution
ExecutorService executor = Executors.newScheduledThreadPool(2);

	a)executor.scheduleAtFixedRate( Runnable command, long initialDelay, long period, TimeUnit unit ) 
	method creates and executes a periodic action that is invoked firstly after the provided initial delay, and subsequently with the 	given period until the service instance shutdowns.

	b)executor.scheduleWithFixedDelay( Runnable command, long initialDelay, long delay, TimeUnit unit ) 
	method creates and executes a periodic action that is invoked firstly after the provided initial delay, and repeatedly with the 	given delay between the termination of the executing one and the invocation of the next one.

//A thread pool with only one thread, which can schedule tasks to run after a delay, or to execute repeatedly with a fixed interval of time in between each execution
ExecutorService executor = Executors.newSingleThreadScheduledExecutor();

//If one thread has finished its work and has nothing more to do, it can “steal” the work from the other thread’s queue
 ExecutorService executor = Executors.newWorkStealingPool(2);  // Introduced in java 8

 
 
CountDownLatch
==============
CountDownLatch (introduced in JDK 5) is a utility class which blocks a set of threads until some operation completes.

A CountDownLatch is initialized with a counter(Integer type); 
This counter decrements as the dependent threads complete execution. 
But once the counter reaches zero, other threads get released.


import java.util.concurrent.CountDownLatch;

class Service extends Thread{
	
	private CountDownLatch countDownLatch;
	
	public Service(String name,CountDownLatch countDownLatch){
		super(name);
		this.countDownLatch=countDownLatch;
	}
	
	public void run(){
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" started ");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}

class DisplayService extends Thread{
	
	private CountDownLatch countDownLatch;
	
	public DisplayService(String name,CountDownLatch countDownLatch){
		super(name);
		this.countDownLatch=countDownLatch;
	}
	
	public void run(){
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName()+" started ");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

/**
 * Java program to demonstrate How to use CountDownLatch in Java. CountDownLatch is
 * useful if you want to start main processing thread once its dependency is completed
 * as illustrated in this CountDownLatch Example
 * 
 * @author Satyanarayana
 */
 
public class MyCountDownLatchTest {

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch=new CountDownLatch(5);
		
		Service service1=new Service("Checking All IO", countDownLatch);
		Service service2=new Service("Checking All Memory Devices", countDownLatch);
		DisplayService service3=new DisplayService("Loading Display Drivers", countDownLatch);
		Service service4=new Service("Loading Device Drivers", countDownLatch);
		Service service5=new Service("Loading something else too", countDownLatch);
		
		service1.start();
		service2.start();
		service3.start();
		service4.start();
		service5.start();
		
		/* 
		 application should not start processing any thread until all service is up and ready to do there job.
	     CountDownLatch is idle choice here, main thread will start with count 5  and wait until count reaches zero. 
	     each thread once up and read will do a count down. 
	     this will ensure that main thread is not started processing until all services is up.
	     
	     count is 5 since we have 5 Threads (Services) 
	     
	     */
		try {
			countDownLatch.await(); //main thread is waiting on CountDownLatch to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" started server");
	}
}


CyclicBarrier
=============

CyclicBarrier works almost same as CountDownLatch except that we can reuse it. 

A CyclicBarrier is a reusable construct where a group of threads waits together until all of the threads arrive. At that point, the barrier is broken and an action can optionally be taken.


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class TextReader implements Runnable {

	private String fileName;
	private CyclicBarrier cyclicBarrier;

	public TextReader(String fileName, CyclicBarrier cyclicBarrier) {
		super();
		this.fileName = fileName;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Reading file " + fileName + " using thread " + Thread.currentThread().getName());
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class AfterAction implements Runnable {
	
	public void run() {
		System.out.println("All Files read , now time to process them");
		System.out.println(Thread.currentThread().getName());
	}
}

public class MyCyclicBarrierDemoClass {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new AfterAction());
		Thread t1=new Thread(new TextReader("file1",  cyclicBarrier));
		Thread t2=new Thread(new TextReader("file2",  cyclicBarrier));
		Thread t3=new Thread(new TextReader("file3",  cyclicBarrier));
		
		t1.start();
		t2.start();
		t3.start();
		
	System.out.println("Main Ends Here");
	}
}

Difference between CountDownLatch and Cyclic Barrier
=====================================================

CountDownLatch and CyclicBarrier are used for managing multi-threaded applications.

And, they are both intended to express how a given thread or group of threads should wait.

CountDownLatch
--------------
A CountDownLatch is a construct that a thread waits on while other threads count down on the latch until it reaches zero.

We can think of this like a dish at a restaurant that is being prepared. No matter which cook prepares however many of the n items, the waiter must wait until all the items are on the plate. If a plate takes n items, any cook will count down on the latch for each item she puts on the plate.

CyclicBarrier
-------------
A CyclicBarrier is a reusable construct where a group of threads waits together until all of the threads arrive. At that point, the barrier is broken and an action can optionally be taken.

We can think of this like a group of friends. Every time they plan to eat at a restaurant they decide a common point where they can meet. They wait for each other there, and only when everyone arrives can they go to the restaurant to eat together.



Semaphore
=========

The Semaphore is used for blocking thread level access to some part of the physical or logical resource.

A semaphore contains a set of permits; whenever a thread tries to enter the critical section, it needs to check the semaphore if a permit is available or not.

If a permit is not available (via tryAcquire()), the thread is not allowed to jump into the critical section; however, if the permit is available the access is granted, and the permit counter decreases.

Once the executing thread releases the critical section, again the permit counter increases (done by release() method).

We can specify a timeout for acquiring access by using the tryAcquire(long timeout, TimeUnit unit) method.

We can also check the number of available permits or the number of threads waiting to acquire the semaphore.


public class SemaphoreDemo {

	static Semaphore semaphore = new Semaphore(4);

	static class MyAtmThread extends Thread {

		public MyAtmThread(String name) {
			super(name);
		}

		public void run() {

			try {
				System.out.println(Thread.currentThread().getName() + " no of free ATM's: " + 				semaphore.availablePermits());
				
				System.out.println(Thread.currentThread().getName() + " acquired Lock ");
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " acquires Permit.");
				
				for (int i = 0; i <= 5; i++) {
					System.out.println(Thread.currentThread().getName() + " is performing operation " 					+ i + " free atm count :" + semaphore.availablePermits());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName()+" releasing Lock...");
				semaphore.release();
				System.out.println(Thread.currentThread().getName()+" free atm's : 							"+semaphore.availablePermits());
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Total No. Of ATM Machines Inside ATM :"+semaphore.availablePermits());
		
		MyAtmThread person1 = new MyAtmThread("Satya");
		MyAtmThread person2 = new MyAtmThread("Ramana");
		MyAtmThread person3 = new MyAtmThread("Sai");
		MyAtmThread person4 = new MyAtmThread("Dhana");
		MyAtmThread person5 = new MyAtmThread("Vikram");
		MyAtmThread person6 = new MyAtmThread("Vinod");
		
		person1.start();
		person2.start();
		person3.start();
		person4.start();
		person5.start();
		person6.start();
	}
}


ThreadFactory
=============

ThreadFactory acts as a thread (non-existing) pool which creates a new thread on demand. 
It eliminates the need of a lot of boilerplate coding for implementing efficient thread creation mechanisms.


ThreadFactory vs default ThreadFactory
--------------------------------------

In a typical Java ExecutorService application where some threads will be assigned from the internal thread pool or created on-demand to perform tasks. Each ExecutorService has an associated ThreadFactory and a default ThreadFactory if the application does not specify one. For non-trivial apps, it’s always a good idea to create a custom ThreadFactory. Why??

a)To set a more descriptive thread name. With the default ThreadFactory, it gives thread names in the form of pool-m-thread-n, such as pool-1-thread-1, pool-2-thread-1, pool-3-thread-1, etc. When analyzing a thread dump, it’s hard to know their purpose and how they were started. So, using a descriptive thread name is the only clue to trace to the source where the ThreadPoolExecutor or ExecutorService is created.

b)To set thread daemon status. The default ThreadFactory produces non-daemon threads.

c)To set thread priority. The default ThreadFactory creates a normal priority threads.



import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
 
/**
 * @author ashraf
 *
 */
public class CustomThreadFactoryBuilder {
     
    private String namePrefix = null;
    private boolean daemon = false;
    private int priority = Thread.NORM_PRIORITY;
 
    public CustomThreadFactoryBuilder setNamePrefix(String namePrefix) {
        if (namePrefix == null) {
            throw new NullPointerException();
        }
        this.namePrefix = namePrefix;
        return this;
    }
 
    public CustomThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = daemon;
        return this;
    }
 
    public CustomThreadFactoryBuilder setPriority(int priority) {
    
        if (priority > Thread.MAX_PRIORITY) {
            throw new IllegalArgumentException(String.format(
                    "Thread priority (%s) must be <= %s", priority,
                    Thread.MAX_PRIORITY));
        }
 
        this.priority = priority;
        return this;
    }
 
    public ThreadFactory build() {
        return build(this);
    }
 
    private static ThreadFactory build(CustomThreadFactoryBuilder builder) {
        final String namePrefix = builder.namePrefix;
        final Boolean daemon = builder.daemon;
        final Integer priority = builder.priority;
 
        final AtomicLong count = new AtomicLong(0);
 
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                if (namePrefix != null) {
                    thread.setName(namePrefix + "-" + count.getAndIncrement());
                }
                if (daemon != null) {
                    thread.setDaemon(daemon);
                }
                if (priority != null) {
                    thread.setPriority(priority);
                }
                return thread;
            }
        };
    }
 }
 
 
 
 public class SimpleTask implements Runnable {

	private long sleepTime;
	private String comment;

	public SimpleTask(String comment , long sleepTime) {
		super();
		this.sleepTime = sleepTime;
		this.comment  = comment;
	}

	@Override
	public void run() {
		//while (true) {
			try {
				System.out.println("Simple task is running on " + Thread.currentThread().getName() + 				" with priority "+ Thread.currentThread().getPriority() +" with comment  "+ comment);
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
	}

}




import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactoryDemo {
	public static void main(String[] args) {

		ThreadFactory customThreadfactory = new CustomThreadFactoryBuilder()
											.setNamePrefix("DemoPool-Thread")
											.setDaemon(false)
											.setPriority(Thread.MAX_PRIORITY)
											.build();

		ExecutorService executorService = Executors.newFixedThreadPool(3, customThreadfactory);

		// Create three simple tasks with 1000 ms sleep time
		SimpleTask simpleTask1 = new SimpleTask("Task1",1000);
		SimpleTask simpleTask2 = new SimpleTask("Task2",1000);
		SimpleTask simpleTask3 = new SimpleTask("Task3",1000);

		// Execute three simple tasks with 1000 ms sleep time
		executorService.execute(simpleTask1);
		executorService.execute(simpleTask2);
		executorService.execute(simpleTask3);

	}
}



BlockingQueue
=============

BlockingQueue interface in Java is added in Java 1.5 along with various other concurrent Utility classes like ConcurrentHashMap, Counting Semaphore, CopyOnWriteArrrayList etc. 

BlockingQueue interface supports flow control (in addition to queue) by introducing blocking if either BlockingQueue is full or empty. A thread trying to enqueue an element in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more element or clearing the queue completely. Similarly it blocks a thread trying to delete from an empty queue until some other treads inserts an item. 

BlockingQueue does not accept null value. If we try to enqueue null item, then it throws NullPointerException.

Java provides several BlockingQueue implementations such as 
LinkedBlockingQueue 
ArrayBlockingQueue
PriorityBlockingQueue
SynchronousQueue etc. 

Java BlockingQueue interface implementations are thread-safe. 

All methods of BlockingQueue are atomic in nature and use internal locks or other forms of concurrency control. 

Java 5 comes with BlockingQueue implementations in the java.util.concurrent package.

https://cdncontribute.geeksforgeeks.org/wp-content/uploads/BlockingQueue.png



BlockingQueue Types
--------------------
The BlockingQueue are two types-

Unbounded Queue: 
The Capacity of blocking queue will be set to Integer.MAX_VALUE. 
In case of unbounded blocking queue, queue will never block because it could grow to a very large size. 
when you add elements it’s size grow.

Syntax:
BlockingQueue blockingQueue = new LinkedBlockingDeque();

Bounded Queue: 
The second type of queue is the bounded queue. 
In case of bounded queue you can create a queue by passing the capacity of queue in queues constructor:

Syntax:
// Creates a Blocking Queue with capacity 5
BlockingQueue blockingQueue = new LinkedBlockingDeque(5);



BlockingQueue API
----------------
There are two types of methods in the BlockingQueue interface 
– methods responsible for adding elements to a queue and 
– methods that retrieve those elements. 

Each method from those two groups behaves differently in case the queue is full/empty.

Adding Elements

add() – returns true if insertion was successful, otherwise throws an IllegalStateException
put() – inserts the specified element into a queue, waiting for a free slot if necessary
offer() – returns true if insertion was successful, otherwise false
offer(E e, long timeout, TimeUnit unit) – tries to insert element into a queue and waits for an available slot within a specified timeout

Retrieving Elements

take() – waits for a head element of a queue and removes it. If the queue is empty, it blocks and waits for an element to become available
poll(long timeout, TimeUnit unit) – retrieves and removes the head of the queue, waiting up to the specified wait time if necessary for an element to become available. Returns null after a timeout

These methods are the most important building blocks from BlockingQueue interface when building producer-consumer programs.


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	
	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i = 0;
		try {
			while (i < 20) {
				System.out.println("Producer Producing" + i);
				queue.put(" " + i);
				i++;
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
		}

	}

}

class Consumer implements Runnable{
		
	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			while(true){
				System.out.println("Consumer Consuming "+queue.take());
			}
		}
		catch(Exception ex){
			
		}
	}
}
public class MyBlockingQueueMain {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);
		
		Producer producerTask=new Producer(blockingQueue);
		Consumer consumerTask=new Consumer(blockingQueue);
		
		Thread producerThread=new Thread(producerTask);
		Thread consumerThread=new Thread(consumerTask);
		
		producerThread.start();
		consumerThread.start();
		
		Thread.sleep(1000);
		
	}
}



DelayQueue
==========

DelayQueue is an infinite-size blocking queue of elements where an element can only be pulled if it’s expiration time (known as user defined delay) is completed. 

Hence, the topmost element (head) will have the most amount delay and it will be polled last.

Each element we want to put into the DelayQueue needs to implement the Delayed interface



When the consumer tries to take an element from the queue, the DelayQueue will execute getDelay() to find out if that element is allowed to be returned from the queue. If the getDelay() method will return zero or a negative number, it means that it could be retrieved from the queue.

We also need to implement the compareTo() method, because the elements in the DelayQueue will be sorted according to the expiration time. The item that will expire first is kept at the head of the queue and the element with the highest expiration time is kept at the tail of the queue:





import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayObject implements Delayed {

	private String data;
	//this is a time when the element should be consumed from the queue.
	private long startTime;

	public DelayObject(String data, long delayInMilliseconds) {
		this.data = data;
		this.startTime = System.currentTimeMillis() + delayInMilliseconds;
	}

	@Override
	public int compareTo(Delayed o) {
		 long diff = this.startTime - ((DelayObject) o).startTime;
		 Integer intVal = Math.toIntExact(diff);
		return intVal;
	}

	//getDelay() should return the remaining delay associated with this object in the given time 	unit.
	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "DelayObject [data=" + data + ", startTime=" + startTime + "]";
	}
}

-----

package com.helpezee.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class DelayQueueConsumer implements Runnable {
   
	private BlockingQueue<DelayObject> queue;
    private final Integer numberOfElementsToTake;
    final AtomicInteger numberOfConsumedElements = new AtomicInteger();

    DelayQueueConsumer(BlockingQueue<DelayObject> queue, Integer numberOfElementsToTake) {
        this.queue = queue;
        this.numberOfElementsToTake = numberOfElementsToTake;
    }


    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToTake; i++) {
            try {
                DelayObject object = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumer take: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


----

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueDemo {

	public static void main(String[] args) {
		
		BlockingQueue<DelayObject> blockingQueue=new DelayQueue<DelayObject>();

		DelayQueueConsumer consumer = new DelayQueueConsumer(blockingQueue, 10);
		DelayQueueProducer producer = new DelayQueueProducer(blockingQueue, 10, 100);
		
		Thread tconsumer = new Thread(consumer);
		Thread tproducer = new Thread(producer);
		
		tproducer.start();
		tconsumer.start();

	}

}



Locks
=====

Lock is a utility for blocking other threads from accessing a certain segment of code, apart from the thread that’s executing it currently.

The Lock interface has been around since Java 1.5. 

It’s defined inside the java.util.concurrent.lock package and it provides extensive operations for locking.

Lock API
--------
Let’s take a look at the methods in the Lock interface:

void lock() – acquire the lock if it’s available; if the lock isn’t available a thread gets blocked until the lock is released

void lockInterruptibly() – this is similar to the lock(), but it allows the blocked thread to be interrupted and resume the 
execution through a thrown java.lang.InterruptedException

boolean tryLock() – this is a non-blocking version of lock() method; it attempts to acquire the lock immediately, return true if locking succeeds

boolean tryLock(long timeout, TimeUnit timeUnit) – this is similar to tryLock(), except it waits up the given timeout before giving up trying to acquire the Lock

void unlock() – unlocks the Lock instance
A locked instance should always be unlocked to avoid deadlock condition. 

A recommended code block to use the lock should contain a try/catch and finally block:


Lock lock = ...; 
lock.lock();
try {
    // access to the shared resource
} finally {
    lock.unlock();
}



Lock implementations
--------------------

ReentrantLock:
--

ReentrantLock class implements the Lock interface.
 
It offers the same concurrency and memory semantics, as the implicit monitor lock accessed using synchronized methods and statements, with extended capabilities.

Let’s see, how we can use ReenrtantLock for synchronization:


public class SharedObject {

    ReentrantLock lock = new ReentrantLock();
    int counter = 0;
 
    public void perform() {
        lock.lock();
        try {
            // Critical section here
            count++;
        } finally {
            lock.unlock();
        }
    }
    //...
}

We need to make sure that we are wrapping the lock() and the unlock() calls in the try-finally block to avoid the deadlock situations.

public void performTryLock(){
 
     boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);
     
    if(isLockAcquired) {
        try {
            //Critical section here
        } finally {
            lock.unlock();
        }
    }
   }

In this case, the thread calling tryLock(), will wait for one second and will give up waiting if the lock isn’t available.



ReentrantReadWriteLock
--

ReentrantReadWriteLock class implements the ReadWriteLock interface.

Let’s see rules for acquiring the ReadLock or WriteLock by a thread:

Read Lock – if no thread acquired the write lock or requested for it then multiple threads can acquire the read lock
Write Lock – if no threads are reading or writing then only one thread can acquire the write lock


public class SynchronizedHashMapWithReadWriteLock {
 
    Map<String,String> syncHashMap = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();
    // ...
    Lock writeLock = lock.writeLock();
 
    public void put(String key, String value) {
        try {
            writeLock.lock();
            syncHashMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
    ...
    public String remove(String key){
        try {
            writeLock.lock();
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }
}


For both the write methods, we need to surround the critical section with the write lock, only one thread can get access to it

	Lock readLock = lock.readLock();

	public String get(String key){
    try {
        readLock.lock();
        return syncHashMap.get(key);
    } finally {
        readLock.unlock();
    }
	}
 
	public boolean containsKey(String key) {
    try {
        readLock.lock();
        return syncHashMap.containsKey(key);
    } finally {
        readLock.unlock();
    }
}


For both read methods, we need to surround the critical section with the read lock. Multiple threads can get access to this section if no write operation is in progress.



StampedLock
--

StampedLock is introduced in Java 8. 
It also supports both read and write locks. 
However, lock acquisition methods returns a stamp that is used to release a lock or to check if the lock is still valid:


Another feature provided by StampedLock is optimistic locking. 
Most of the time read operations doesn’t need to wait for write operation completion and as a result of this, the full-fledged read lock isn’t required.


StampedLock sl = new StampedLock();
//acquiring writelock
long stamp =  sl.writeLock();
try{
 ...
 ...
}finally {
 //releasing lock
 sl.unlockWrite(stamp);
}


Modes in Java StampedLock
-------------------------

As already mentioned StampedLock has an extra mode optimistic reading apart from reading and writing.

Writing mode– 
When you try to acquire a write lock. It can be done using Method writeLock() which exclusively acquires the lock, blocking if necessary until available. This method returns a stamp that can be used in method unlockWrite(long)to release the lock or in conversion of the lock.
Untimed  and timed versions of tryWriteLock are also provided. This method won’t block and return stamp as zero if the lock is not immediately available (or with in the given in case of timed version). When the lock is held in write mode, no read locks may be obtained, and all optimistic read validations will fail.

Reading Mode– 
When you try to acquire a read lock. It can be done using method readLock() which non-exclusively acquires the lock, blocking if necessary until available returning a stamp that can be used to unlock or convert mode. Untimed and timed versions of tryReadLock are also provided.

Optimistic Reading– 
That is the new mode added in StampedLock. Method tryOptimisticRead() is used to read in optimistic mode. This method returns a non-zero stamp only if the lock is not currently held in write mode.
Method validate(long) is used to validate if the values read optimistically are correct or not. 
Validate() method returns true if the lock has not been acquired in write mode since obtaining a given stamp.






import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

	 int c = 0;
	    public static void main(String[] args) {
	    	
	        StampedLock sl = new StampedLock();
	        ExecutorService executor = Executors.newFixedThreadPool(2);
	        StampedLockDemo cst = new StampedLockDemo();
	        
	        
	        // Runnable as lambda - read
	        Runnable readTask = ()->{
	            long stamp = sl.readLock();
	            try{
	                System.out.println("value " + cst.getValue());
	                
	            }finally{
	                sl.unlockRead(stamp);
	            }
	        };
	        
	        // Runnable as lambda - Write lock
	        Runnable writeTask = ()->{
	            long stamp = sl.writeLock();
	            try {
	                cst.increment();
	            }finally{
	                sl.unlockWrite(stamp);
	            }
	        };
	        
	        // 3 write tasks
	        executor.submit(writeTask);
	        executor.submit(writeTask);
	        executor.submit(writeTask);
	        // 1 read task
	        executor.submit(readTask);
	        executor.shutdown();

	    }
	    public  void increment() {     
	        c++;
	        System.out.println("in increment " + c);
	    }

	    public  int getValue() {
	        return c;
	    }

	}

Output:

in increment 1
in increment 2
in increment 3
value 3




import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class StampedLockWithryOptimisticRead {

	public static void main(String[] args) {
		
		StampedLock sl = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Runnable as lambda - optimistic read
        Runnable r1 = ()->{
            long stamp = sl.tryOptimisticRead();
            try{
                System.out.println("In optimistic lock " + sl.validate(stamp));
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("In optimistic lock " + sl.validate(stamp));
                
            }finally{
                sl.unlock(stamp);
            }
        };
        
        // Runnable as lambda - Write lock
        Runnable r2 = ()->{
            System.out.println("about to get write lock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long stamp = sl.writeLock();
            try{
                System.out.println("After getting write lock ");
                
            }finally{
                sl.unlock(stamp);
                System.out.println("Relinquished write lock ");
            }
        };
        
        executor.submit(r2);
        // Optimistic read
        executor.submit(r1);
        executor.submit(r2);
        
        executor.shutdown();
    }
}


Output

about to get write lock
In optimistic lock true
After getting write lock 
Relinquished write lock 
about to get write lock
In optimistic lock false
After getting write lock 
Relinquished write lock 


Here it can be seen when write lock is acquired at that time validate method returns false for optimistic read. Optimistic mode can be thought of as an extremely weak version of a read-lock, that can be broken by a writer at any time, from the output you can see the same thing.

Before acquiring the write lock thread goes to sleep and the optimistic lock is acquired in the mean time. When the write lock is acquired later, optimistic read lock is broken so the validate method returns false for the same stamp



Differences between Lock and Synchronized block
================================================
There are few differences between the use of synchronized block and using Lock API’s:

A synchronized block is fully contained within a method – we can have Lock API’s lock() and unlock() operation in separate methods

A synchronized block doesn’t support the fairness, any thread can acquire the lock once released, no preference can be specified. We can achieve fairness within the Lock APIs by specifying the fairness property. It makes sure that longest waiting thread is given access to the lock.

A thread gets blocked if it can’t get an access to the synchronized block. The Lock API provides tryLock() method. The thread acquires lock only if it’s available and not held by any other thread. This reduces blocking time of thread waiting for the lock.

A thread which is in “waiting” state to acquire the access to synchronized block, can’t be interrupted. The Lock API provides a method lockInterruptibly() which can be used to interrupt the thread when it’s waiting for the lock.


Working with Conditions
=======================

The Condition class provides the ability for a thread to wait for some condition to occur while executing the critical section.

This can occur when a thread acquires the access to the critical section but doesn’t have the necessary condition to perform its operation. 

For example, a reader thread can get access to the lock of a shared queue, which still doesn’t have any data to consume.

Traditionally Java provides wait(), notify() and notifyAll() methods for thread intercommunication. 
Conditions have similar mechanisms, but in addition, we can specify multiple conditions:


    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();
    
    
    stackFullCondition.await()
    ---------------------------
    Causes the current thread to wait until it is signaled or interrupted. 

	The lock associated with this Condition is atomically released and the current thread becomes 	disabled for thread scheduling purposes and lies dormant until one of four things happens: 

	1.Some other thread invokes the signal method for this Condition and the current thread 	happens to be chosen as the thread to be awakened; 

	2.Some other thread invokes the signalAll method for this Condition; 

	3.Some other thread interrupts the current thread, and interruption of thread suspension is 	supported; 

	4.A "spurious wakeup" occurs. 


	stackFullCondition.signalAll()
	---------------------------
	Wakes up all waiting threads. 

	If any threads are waiting on this condition then they are all woken up. 
	Each thread must re-acquire the lock before it can return from await. 
	
	
	package com.helpezee.lock;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {

	private Stack<String> stack = new Stack<>();
	private static final int CAPACITY = 5;

	private ReentrantLock lock = new ReentrantLock();
	private Condition stackEmptyCondition = lock.newCondition();
	private Condition stackFullCondition = lock.newCondition();

	private void pushToStack(String item) throws InterruptedException {
		try {
			lock.lock();
			if (stack.size() == CAPACITY) {
				System.out.println(Thread.currentThread().getName() + " wait on stack full");
			// Causes the current thread to wait until it is signaled or interrupted. 
			stackFullCondition.await();
			}
			System.out.println("Pushing the item " + item);
			stack.push(item);
			stackEmptyCondition.signalAll();
		} finally {
			lock.unlock();
		}

	}

	private String popFromStack() throws InterruptedException {
		try {
			lock.lock();
			if (stack.size() == 0) {
				System.out.println(Thread.currentThread().getName() + " wait on stack empty");
				stackEmptyCondition.await();
			}
			return stack.pop();
		} finally {
			//Wakes up all waiting threads. 
			stackFullCondition.signalAll();
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		
		final int threadCount = 2;
		ReentrantLockWithCondition object = new ReentrantLockWithCondition();
		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
		
		service.execute(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					object.pushToStack("Item " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		service.execute(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Item popped " + object.popFromStack());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		service.shutdown();
	}
}

	
Output:

Pushing the item Item 0
Pushing the item Item 1
Pushing the item Item 2
Pushing the item Item 3
Pushing the item Item 4
pool-1-thread-1 wait on stack full

Item popped Item 4
Item popped Item 3
Item popped Item 2
Item popped Item 1
Item popped Item 0

Pushing the item Item 5
Pushing the item Item 6
Pushing the item Item 7
Pushing the item Item 8
Pushing the item Item 9

Item popped Item 9
Item popped Item 8
Item popped Item 7
Item popped Item 6
Item popped Item 5


Phaser
=======

It is a very similar construct to the CountDownLatch that allows us to coordinate execution of threads.
In the CountDownLatch that number cannot be configured dynamically and needs to be supplied when we’re creating the instance. 
In comparison to the CountDownLatch, it has some additional functionality.

The Phaser is a barrier on which the dynamic number of threads need to wait before continuing execution. 

Phaser in Java is also one of the synchronization aid provided in concurrency util. Phaser is similar to other synchronization barrier utils like CountDownLatch and CyclicBarrier. 

What sets Phaser apart is it is reusable (like CyclicBarrier) and more flexible in usage. In both CountDownLatch and CyclicBarrier number of parties (thread) that are registered for waiting can't change where as in Phaser that number can vary. 

Also note that Phaser has been introduced in Java 7.

Phaser in Java is more suitable for use where it is required to synchronize threads over one or more phases of activity. Though Phaser can be used to synchronize a single phase, in that case it acts more like a CyclicBarrier. But it is more suited where threads should wait for a phase to finish, then advance to next phase, wait again for that phase to finish and so on.

How Phaser is more flexible?

Unlike the case for other barriers, the number of parties registered to synchronize on a Phaser may vary over time. Tasks may be registered at any time (using methods register(), bulkRegister(int), or by specifying initial number of parties in the constructor). Tasks may also be optionally deregistered upon any arrival (using arriveAndDeregister()).

Java Phaser constructors
------------------------

Phaser class in Java has 4 constructors

Phaser()- 
Creates a new phaser with no initially registered parties, no parent, and initial phase number 0.
Phaser(int parties)- Creates a new phaser with the given number of registered unarrived parties, no parent, and initial phase number 0.

 
Phaser(Phaser parent)- 
Creates a new phaser with the given parent with no initially registered parties.
Phaser(Phaser parent, int parties)- Creates a new phaser with the given parent and number of registered unarrived parties.

How Phaser in Java works
--------------------------

First thing is to create a new instance of Phaser.

Next thing is to register one or more parties with the Phaser. That can be done using register(), bulkRegister(int) or by specifying number of parties in the constructor.

Now since Phaser is a synchronization barrier so we have to make phaser wait until all registered parties finish a phase. That waiting can be done using arrive() or any of the variants of arrive() method. When the number of arrivals is equal to the parties which are registered that phase is considered completed and it advances to next phase (if there is any), or terminate.

Note that each generation of a phaser has an associated phase number. 
The phase number starts at zero, and advances when all parties arrive at the phaser, wrapping around to zero after reaching Integer.MAX_VALUE.


 
Methods in Java Phaser class
----------------------------

Some of the methods in Phaser class are as given below-

resgister()- 
Adds a new unarrived party to this phaser. It returns the arrival phase number to which this registration applied.

arrive()- Arrives at this phaser, without waiting for others to arrive. Note that arrive() method does not suspend execution of the calling thread. Returns the arrival phase number, or a negative value if terminated. Note that this method should not be called by an unregistered party.

arriveAndDeregister()- 
Arrives at this phaser and de-registers from it without waiting for others to arrive. Returns the arrival phase number, or a negative value if terminated.

arriveAndAwaitAdvance()- 
This method awaits other threads to arrives at this phaser. Returns the arrival phase number, or the (negative) current phase if terminated. If you want to wait for all the other registered parties to complete a given phase then use this method.

bulkRegister(int parties)– 
Used to register parties in bulk. Given number of new unarrived parties will be registered to this phaser.

onAdvance(int phase, int registeredParties)– 
If you want to perform some action before the phase is advanced you can override this method. Also used to control termination.

Phaser Monitoring
-----------------
Phaser class in Java has several methods for monitoring. These methods can be called by any caller not only by registered parties.

getRegisteredParties() - 
Returns the number of parties registered at this phaser.

getArrivedParties() - 
Returns the number of registered parties that have arrived at the current phase of this phaser.

getUnarrivedParties() - 
Returns the number of registered parties that have not yet arrived at the current phase of this phaser.

getPhase() - 
Returns the current phase number.

--

public class FileReaderThread implements Runnable {
	 
	private String threadName;
	private String fileName;
	private Phaser ph;

	 FileReaderThread(String threadName, String fileName, Phaser ph){
	  this.threadName = threadName;
	  this.fileName = fileName;
	  this.ph = ph;
	  
	  ph.register();
	 // new Thread(this).start();
	 }
	 @Override
	 public void run() {
	  System.out.println("This is phase " + ph.getPhase());
	  
	  try {
	   Thread.sleep(20);
	   System.out.println("Reading file " + fileName + " thread " + threadName + " parsing and 		storing to DB ");
	   // Using await and advance so that all thread wait here
	   ph.arriveAndAwaitAdvance();
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	  ph.arriveAndDeregister();
	 }
	}
	
	
	public class QueryThread implements Runnable {
	private String threadName;
	private int param;
	private Phaser ph;

	QueryThread(String threadName, int param, Phaser ph) {
		this.threadName = threadName;
		this.param = param;
		this.ph = ph;
		ph.register();
		new Thread(this).start();
	}

	@Override
	 public void run() {
	  
	  System.out.println("This is phase " + ph.getPhase());
	  System.out.println("Querying DB using param " + param 
	                  + " Thread " + threadName);
	  ph.arriveAndAwaitAdvance();
	  System.out.println("Threads finished");
	  ph.arriveAndDeregister();
	 }
}
	
	
	
	public class PhaserDemo {

	public static void main(String[] args) {

		Phaser ph = new Phaser(1);
		int curPhase;

		curPhase = ph.getPhase();
		System.out.println("Phase in Main " + curPhase + " started");
		
		// Threads for first phase
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new FileReaderThread("thread-1", "file-1", ph));
		executorService.submit(new FileReaderThread("thread-2", "file-2", ph));
		executorService.submit(new FileReaderThread("thread-3", "file-3", ph));

		// For main thread
		ph.arriveAndAwaitAdvance();
		System.out.println("New phase " + ph.getPhase() + " started");
		
		// Threads for second phase
		executorService.submit(new QueryThread("thread-1", 40, ph));
		executorService.submit(new QueryThread("thread-2", 40, ph));
		
		curPhase = ph.getPhase();
		ph.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " completed");
		
		// deregistering the main thread
		ph.arriveAndDeregister();
	}
}
	
Reference : https://netjs.blogspot.com/2016/01/phaser-in-java-concurrency.html



Synchronization
===============

Simply put, in a multi-threaded environment, a race condition occurs when two or more threads attempt to update mutable shared data at the same time. 

Java offers a mechanism to avoid race conditions by synchronizing thread access to shared data.

A piece of logic marked with synchronized becomes a synchronized block, allowing only one thread to execute at any given time.


The Synchronized Keyword
-------------------------
The synchronized keyword can be used on different levels:

Instance methods
Static methods
Code blocks

When we use a synchronized block, internally Java uses a monitor also known as monitor lock or intrinsic lock, to provide synchronization. 

These monitors are bound to an object, thus all synchronized blocks of the same object can have only one thread executing them at the same time.

Refer to package for examples : com.helpezee.synchronization



Volatile 
========

In Java, each thread has a separate memory space known as working memory; 
this holds the values of different variables used for performing operations. 

After performing an operation, thread copies the updated value of the variable to the main memory, and from there other threads can read the latest value.

Simply put, the volatile keyword marks a variable to always go to main memory, for both reads and writes, in the case of multiple threads accessing it.

