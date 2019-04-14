package com.helpezee.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Computation2 implements Runnable {
	public static int sum = 0;
	CyclicBarrier cyclicBarrier;

	public Computation2(CyclicBarrier cyclicBarrier) {
		super();
		this.cyclicBarrier = cyclicBarrier;
	}

	public void run() {
		// check if newBarrier is broken or not
		System.out.println(Thread.currentThread().getName() + " Is the barrier broken? - " + cyclicBarrier.isBroken());
		sum = 10 + 20;
		try {
			//cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
			cyclicBarrier.await();

			// number of parties waiting at the barrier
			System.out.println(Thread.currentThread().getName() +"  Number of parties waiting at the barrier at this point = " + cyclicBarrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		} 
	}
}