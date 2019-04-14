package com.helpezee.demo;

class DemoThread extends Thread{
	public void run(){
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+" i : "+i);
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
	}
}
public class MyJoinDemoClass {

	public static void main(String[] args) {
		DemoThread t1=new DemoThread();
		DemoThread t2=new DemoThread();
		DemoThread t3=new DemoThread();
		DemoThread t4=new DemoThread();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t4.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		for(int i=1;i<=10;i++){
			System.out.println(Thread.currentThread().getName()+" i : "+i);
		}
		System.out.println("Good Bye from "+Thread.currentThread().getName());
		
	}

}
