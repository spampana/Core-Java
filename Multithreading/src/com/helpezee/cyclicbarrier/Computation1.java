package com.helpezee.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Computation1 implements Runnable {
	public static int product = 0;
	CyclicBarrier cyclicBarrier;

	public Computation1(CyclicBarrier cyclicBarrier) {
		super();
		this.cyclicBarrier = cyclicBarrier;
	}

	public void run() {
		product = 2 * 3;
		try {
			cyclicBarrier.await();
			
			// number of parties waiting at the barrier
			System.out.println(Thread.currentThread().getName() +" Number of parties waiting at the barrier at this point = " + cyclicBarrier.getNumberWaiting());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}