package com.helpezee.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,20,30,40);
        list.stream()
        .map(data->CompletableFuture.supplyAsync(()->getNumber(data)))
        .map(compFuture->compFuture.thenApply(n->n*n))
        .map(t->t.join())
        .forEach(s->System.out.println(s));
        
        System.out.println("Main Thread Ends");
      }
	
    private static int getNumber(int a){
        return a*a;
    }

    

}
