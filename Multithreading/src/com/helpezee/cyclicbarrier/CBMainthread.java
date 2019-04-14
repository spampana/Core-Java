package com.helpezee.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CBMainthread {

	public static void main(String[] args) {
		
		Runnable action = new Runnable() {
			@Override
			public void run() {
				System.out.println("----------------------------------");
				System.out.println(Thread.currentThread().getName() +" After completion of two threads");
				System.out.println("----------------------------------");
				
				// barrier breaks as the number of thread waiting for the barrier at this point = 3
				System.out.println(Thread.currentThread().getName() + " Sum of product and sum = " + (Computation1.product + Computation2.sum));

			}
		};

		CyclicBarrier newBarrier = new CyclicBarrier(2, action);

		// objects on which the child thread has to run
		Computation1 com1 = new Computation1(newBarrier);
		Computation2 com2 = new Computation2(newBarrier);

		System.out.println(Thread.currentThread().getName()+ " Number of parties required to trip the barrier = " + newBarrier.getParties());
		System.out.println(Thread.currentThread().getName() + " Sum of product and sum = " + (Computation1.product + Computation2.sum));

		// creation of child thread
		Thread t1 = new Thread(com1 ,"Comp1");
		Thread t2 = new Thread(com2, "Comp2");

		// moving child thread to runnable state
		t1.start();
		t2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Resetting the newBarrier
		newBarrier.reset();
		System.out.println("Barrier reset successful");

	}

}
