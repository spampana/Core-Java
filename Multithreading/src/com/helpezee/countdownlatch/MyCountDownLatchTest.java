package com.helpezee.countdownlatch;

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
	     Countdown latch is idle choice here, main thread will start with count 5  and wait until count reaches zero. 
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
