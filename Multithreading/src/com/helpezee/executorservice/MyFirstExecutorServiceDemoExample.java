package com.helpezee.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class HiTask implements Runnable{

	private String taskName;
	
	public HiTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Hi from "+taskName);
		
	}
	
}
public class MyFirstExecutorServiceDemoExample {

	public static void main(String[] args) {

		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		
		for(int i=1;i<=50;i++){
			threadPool.execute(new HiTask("task "+i));
		}
		
		threadPool.execute(new HiTask("Shiva"));
		threadPool.shutdown();
		threadPool.execute(new HiTask("Sujata"));
	}

}
