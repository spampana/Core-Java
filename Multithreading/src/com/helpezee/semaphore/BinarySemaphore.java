package com.helpezee.semaphore;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BinarySemaphore {
	public static void main(String[] args) {
		final int threadCount = 5;
		final ExecutorService exService = Executors.newFixedThreadPool(threadCount);
		final Printer printer = new Printer();
		for (int i=1; i<= threadCount; i++) {
			exService.execute(new Job(printer, "Job-"+i));
		}
		exService.shutdown();
	}
}

//Refer: https://helpezee.wordpress.com/2019/04/16/binary-semaphore/




