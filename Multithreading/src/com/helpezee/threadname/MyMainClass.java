package com.helpezee.threadname;

class MyThread extends Thread{
	
	public MyThread(){
		super();
	}
	
	public MyThread(String name){
		super(name);
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+" welcomes you");
		for(int j=1; j<10; j++){
			System.out.println(Thread.currentThread().getName()+" "+j);
		}
	}
}

public class MyMainClass {
	public static void main(String[] args){
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread("Dhana");
		MyThread thread3 = new MyThread();
		thread3.setName("Raju");
		thread1.start();
		thread2.start();
		thread3.start();
		for(int i=1; i<10; i++){
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}
