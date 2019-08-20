package com.helpezee.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueDemo {

	public static void main(String[] args) {
		
		BlockingQueue<DelayObject> blockingQueue=new DelayQueue<DelayObject>();

		DelayQueueConsumer consumer = new DelayQueueConsumer(blockingQueue, 10);
		DelayQueueProducer producer = new DelayQueueProducer(blockingQueue, 10, 100);
		
		Thread tconsumer = new Thread(consumer);
		Thread tproducer = new Thread(producer);
		
		tproducer.start();
		tconsumer.start();

	}

}
