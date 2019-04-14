package com.helpezee.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class HelloTask implements Runnable{

	private String taskName;
	
	public HelloTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" hello from "+taskName);
		
	}
	
}
public class MyFirstExecutorDemoExample {

	public static void main(String[] args) {
		Executor threadPool=Executors.newFixedThreadPool(2);
		for(int i=1;i<=20;i++){
			threadPool.execute(new HelloTask("task "+i));
		}
		
		threadPool.execute(new HelloTask("Sujata"));
	}

}
