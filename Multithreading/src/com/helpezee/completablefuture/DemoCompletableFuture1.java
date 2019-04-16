package com.helpezee.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class DemoCompletableFuture1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		    // Simulate a long-running Job   
		    try {
		    	System.out.println("Hello");
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    System.out.println("I'll run in a separate thread than the main thread.");
		   
		});
		System.out.println("Something:"+future.get());

    }


}
