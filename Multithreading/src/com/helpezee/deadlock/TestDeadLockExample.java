package com.helpezee.deadlock;

public class TestDeadLockExample {

	public static Object lock1=new Object();
	public static Object lock2=new Object();
	
	public static void main(String[] args) {
		MyThread1 t1=new MyThread1();
		MyThread2 t2=new MyThread2();
		t1.start();
		t2.start();

	}
	
	public static class MyThread1 extends Thread{
		public void run(){
			synchronized (lock1) {
				System.out.println("Thread 1 Holding Lock 1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("Thread 1 Holding Lock1 and Lock2");
				}
			}
		}
	}

	public static class MyThread2 extends Thread{
		public void run(){
			synchronized (lock2) {
				System.out.println("Thread 2 Holding Lock 2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("Thread 2 Holding Lock1 and Lock2");
				}
			}
		}
	}
}
