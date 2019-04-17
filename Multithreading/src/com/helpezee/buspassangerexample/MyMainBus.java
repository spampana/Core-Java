package com.helpezee.buspassangerexample;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


class Passangers extends Thread{
	
	private String passangerName;
	private Semaphore semaphore;
	private CountDownLatch countDownLatch;
	
	
	public Passangers(String passangerName, Semaphore semaphore, CountDownLatch countDownLatch) {
		super(passangerName);
		this.passangerName = passangerName;
		this.semaphore = semaphore;
		this.countDownLatch = countDownLatch;
	}


	public void run(){
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+" gets the seat ");
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
public class MyMainBus {

	public static void main(String[] args) {
		
		Semaphore semaphore=new Semaphore(5);
		CountDownLatch countDownLatch=new CountDownLatch(5);
		ArrayList<Passangers> passangerList=new ArrayList<>();
		
		for(int i=0;i<=8;i++){
			passangerList.add(new Passangers("Pasanger "+i , semaphore, countDownLatch));
			
		}
		for(Passangers passanger:passangerList){
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
