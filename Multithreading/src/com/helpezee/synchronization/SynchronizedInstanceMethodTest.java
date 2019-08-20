package com.helpezee.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedInstanceMethodTest {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService service = Executors.newFixedThreadPool(3);

		SynchronizedInstanceMethod race = new SynchronizedInstanceMethod();

		IntStream.range(0, 50).forEach(count -> service.submit(race::calculate));

		service.awaitTermination(1000, TimeUnit.MILLISECONDS);

		System.out.println(race.getSum());
	}

}
