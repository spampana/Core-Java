package com.helpezee.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> completableFutureToBeCompleted2 = CompletableFuture.supplyAsync( ( ) ->{
			
			//Going to infinite loop
			for( int i = 0; i < 10; i-- ){
			    System.out.println( "i " + i );
			}
			
			return 10;
			} );
		
		CompletableFuture<Integer> completor = CompletableFuture.supplyAsync( ( ) -> {
			    System.out.println( "completing the other" );
			    completableFutureToBeCompleted2.complete( 222 );
			    return 10;
			} );

		System.out.println("val :"+completor.get());
		System.out.println("value:"+completableFutureToBeCompleted2.get());

	}

}
