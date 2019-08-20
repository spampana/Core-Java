package com.helpezee.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	
	private BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i = 0;
		try {
			while (i < 20) {
				System.out.println("Producer Producing" + i);
				queue.put(" " + i);
				i++;
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
		}

	}

}

class Consumer implements Runnable{
		
	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try{
			while(true){
				System.out.println("Consumer Consuming "+queue.take());
			}
		}
		catch(Exception ex){
			
		}
	}
}
public class MyBlockingQueueMain {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);
		
		Producer producerTask=new Producer(blockingQueue);
		Consumer consumerTask=new Consumer(blockingQueue);
		
		Thread producerThread=new Thread(producerTask);
		Thread consumerThread=new Thread(consumerTask);
		
		producerThread.start();
		consumerThread.start();
		
		Thread.sleep(1000);
		
	}
}
