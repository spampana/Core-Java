package com.helpezee.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallBackThenApply {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture
				.supplyAsync(() ->{ 
					try {
						Thread.sleep(2000);
					} catch (Exception e) {

						e.printStackTrace();
					}
					return "XXXX";});
		
		
		CompletableFuture<String> oneMore=future.thenApply(value->"Manipulated "+value);

		System.out.println(oneMore.get());
//		System.out.println("Something:"+oneMore.getNow("NA"));
//		Thread.sleep(3000);
//		System.out.println("Again enquiring value from onemore "+oneMore.getNow("NA"));

    }

    

}
