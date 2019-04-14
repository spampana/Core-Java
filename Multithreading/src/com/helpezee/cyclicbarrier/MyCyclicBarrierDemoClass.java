package com.helpezee.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class TextReader implements Runnable {

	private String fileName;
	private String threadName;
	private CyclicBarrier cyclicBarrier;

	public TextReader(String fileName, String threadName, CyclicBarrier cyclicBarrier) {
		super();
		this.fileName = fileName;
		this.threadName = threadName;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Reading file " + fileName + " using thread " + threadName);
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class AfterAction implements Runnable {
	public void run() {
		System.out.println("All Files read , not time to process them");
	}
}

public class MyCyclicBarrierDemoClass {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new AfterAction());
		Thread t1=new Thread(new TextReader("file1", "thread1", cyclicBarrier));
		Thread t2=new Thread(new TextReader("file2", "thread2", cyclicBarrier));
		Thread t3=new Thread(new TextReader("file3", "thread3", cyclicBarrier));
		
		t1.start();
		t2.start();
		t3.start();
		
//		System.out.println("Main Ends Here");
	}

}
