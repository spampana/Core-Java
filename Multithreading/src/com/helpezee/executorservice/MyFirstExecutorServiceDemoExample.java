package com.helpezee.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RunnableTask implements Runnable{

	private String taskName;
	
	public RunnableTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Hi from "+taskName);
		
	}
	
}

class CallableTask implements Callable<String>{

	private String taskName;
	
	public CallableTask(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" Hi from "+taskName);
		return "Response  from callable Task";
	}
	
}



public class MyFirstExecutorServiceDemoExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService threadPool=Executors.newFixedThreadPool(5);
		
		System.out.println(" ### Executing the Runnable Task using execute() ###");
		for(int i=1;i<=3;i++){
			threadPool.execute(new RunnableTask("task "+i));
		}
		Thread.sleep(3000);
		
		System.out.println(" ### Executing the Callable Task using submit() ###");
		Future<String> result = threadPool.submit(new CallableTask("Shiva"));
		System.out.println(result.get());
		
		Thread.sleep(3000);
		
		
		List<Callable<String>> callableTasksList = new ArrayList<>();
		callableTasksList.add(new CallableTask("Satya"));
		callableTasksList.add(new CallableTask("Narayana"));
		callableTasksList.add(new CallableTask("Pampana"));
		
		System.out.println(" ### Executing the Callable Task using invokeAny() ###");
		String firstresult = threadPool.invokeAny(callableTasksList);
		System.out.println(firstresult);
		
		 Thread.sleep(3000);
		 
		System.out.println(" ### Executing the Callable Task using InvokeAll() ###");
		List<Future<String>> results = threadPool.invokeAll(callableTasksList);
		results.forEach(response-> {
			try {
				System.out.println(response.get(200, TimeUnit.MILLISECONDS));
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		});
			
				
		//threadPool.shutdown();
		
		List<Runnable> notExecutedTasks;
		
		try {
		    if (!threadPool.awaitTermination(800, TimeUnit.MILLISECONDS)) {
		    	notExecutedTasks = threadPool.shutdownNow();
		    	notExecutedTasks.forEach(System.out::println);
		    }
		} catch (InterruptedException e) {
			threadPool.shutdownNow();
		}
				
	
	}

}
