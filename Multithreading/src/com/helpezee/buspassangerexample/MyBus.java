package com.helpezee.buspassangerexample;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


class MyPassangers extends Thread{
	
	private String passangerName;
	private Semaphore semaphore;
	private CountDownLatch countDownLatch;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MyPassangers(String passangerName, Semaphore semaphore, CountDownLatch countDownLatch) {
		super(passangerName);
		this.passangerName = passangerName;
		this.semaphore = semaphore;
		this.countDownLatch = countDownLatch;
	}


	public void run(){
		if(status.equals("book"))
			book();
		else
			cancel();
	}
	

	public void book(){
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+" gets the seat ");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void cancel(){
			System.out.println(Thread.currentThread().getName()+" cancels the seat");
			semaphore.release();
	}
}
public class MyBus {

	public static void main(String[] args) {
		
		Semaphore semaphore=new Semaphore(5);
		CountDownLatch countDownLatch=new CountDownLatch(5);
		ArrayList<MyPassangers> passangerList=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<=8;i++){
			passangerList.add(new MyPassangers("Pasanger "+i , semaphore, countDownLatch));
			System.out.println("Enter book for booking and cancel for cancel");
			passangerList.get(i).setStatus(sc.next());
			
		}
		
		for(MyPassangers passanger:passangerList){
			passanger.start();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Bus is with full capacity and left from bus stop");

	}

}
