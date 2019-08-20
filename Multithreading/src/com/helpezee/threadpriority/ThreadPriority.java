package com.helpezee.threadpriority;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->System.out.println("Welcome to "+Thread.currentThread().getName()), "FirstThread");
		Thread t2 = new Thread(()->System.out.println("Welcome to "+Thread.currentThread().getName()), "SecondThread");
		Thread t3 = new Thread(()->System.out.println("Welcome to "+Thread.currentThread().getName()), "ThirdThread");
		Thread t4 = new Thread(()->System.out.println("Welcome to "+Thread.currentThread().getName()), "FourThread");
		
		t1.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);
		
		t4.start();
		t1.start();
		t2.start();
		t3.start();
	}

}

