package com.helpezee.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	static Semaphore semaphore = new Semaphore(4);

	static class MyAtmThread extends Thread {

		public MyAtmThread(String name) {
			super(name);
		}

		public void run() {

			try {
				System.out.println(Thread.currentThread().getName() + " no of free ATM's: " + semaphore.availablePermits());
				
				System.out.println(Thread.currentThread().getName() + " acquired Lock ");
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " acquires Permit.");
				
				for (int i = 0; i <= 5; i++) {
					System.out.println(Thread.currentThread().getName() + " is performing operation " + i + " free atm count :" + semaphore.availablePermits());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName()+" releasing Lock...");
				semaphore.release();
				System.out.println(Thread.currentThread().getName()+" free atm's : "+semaphore.availablePermits());
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

//Refer : https://helpezee.wordpress.com/2019/04/16/semaphore/
