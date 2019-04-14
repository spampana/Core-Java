package com.helpezee.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MyTask implements Callable<String> {
	
	private String name;

	public MyTask(String name) {
		super();
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		if (name.equals("First")) {
			while (true) {

			}
		}
		return "Hello " + name;
	}
}

public class MyFirstCallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);

		Future<String> firstReturnType = threadPool.submit(new MyTask("First"));
		Future<String> secondReturnType = threadPool.submit(new MyTask("Second"));
		try {
			System.out.println(firstReturnType.get(1L, TimeUnit.SECONDS));
		} catch (TimeoutException ex) {
			System.out.println("Unable to get response this time");
		}
		System.out.println(secondReturnType.get());

	}

}
