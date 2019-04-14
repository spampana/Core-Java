package com.helpezee.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableDemo implements Callable<String> {
	
	private String name;

	public CallableDemo(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		return "hello " + name + " you are here at " + new Date();
	}

}

public class MySecondCallableExample {

	public static void main(String args[]){
		
		List<Future<String>> futureList=new ArrayList<>();
		
		List<CallableDemo> taskList=new ArrayList<>();
		
		taskList.add(new CallableDemo("first"));
		taskList.add(new CallableDemo("second"));
		taskList.add(new CallableDemo("third"));
		taskList.add(new CallableDemo("fourth"));
		taskList.add(new CallableDemo("fifth"));
		
		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		
		for(CallableDemo task:taskList){
			futureList.add(threadPool.submit(task));
		}
		
		for(Future<String> future:futureList){
			
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
