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
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" started server");
		

	}

}
