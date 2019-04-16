package com.helpezee.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MyFirstCompletableFutureDemo {

	public static void main(String[] args) {
		
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Demonstrating Completable Future");
		});

		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Ends Here");
	}

}
