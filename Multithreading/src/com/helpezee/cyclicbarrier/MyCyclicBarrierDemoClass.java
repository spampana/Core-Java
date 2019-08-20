package com.helpezee.cyclicbarrier;

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
