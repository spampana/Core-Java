package com.helpezee.demo;

public class MyFirstVolatileDemo extends Thread {

	volatile boolean keepRunning=true;
	
	public void run(){
		long counter=0;
		while(keepRunning){
			counter++;
		}
		System.out.println(Thread.currentThread().getName()+" terminated with counter value = "+counter);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		MyFirstVolatileDemo thread1=new MyFirstVolatileDemo();
		thread1.start();
		
		Thread.sleep(1000);
		thread1.keepRunning=false;
		thread1.join();
		System.out.println(Thread.currentThread().getName()+" Thread Keep running set to "+thread1.keepRunning);

	}

}
