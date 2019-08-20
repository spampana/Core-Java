package com.helpezee.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RaceconditionTest {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = Executors.newFixedThreadPool(3);
		
		RaceCondition race= new RaceCondition();
		
		IntStream.range(0, 100).forEach(count -> service.submit(race::calculate));
		
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		
		System.out.println(race.getSum());
	    
	    //We’re simply using an ExecutorService with a 3-threads pool to execute the calculate() 100 times.
	    //If we would execute this serially, the expected output would be 100, but our multi-threaded execution fails almost every time with an inconsistent actual output 	    

	}

}
