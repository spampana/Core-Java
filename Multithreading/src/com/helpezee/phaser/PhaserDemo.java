package com.helpezee.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

	public static void main(String[] args) {

		Phaser ph = new Phaser(1);
		int curPhase;

		curPhase = ph.getPhase();
		System.out.println("Phase in Main " + curPhase + " started");
		
		// Threads for first phase
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new FileReaderThread("thread-1", "file-1", ph));
		executorService.submit(new FileReaderThread("thread-2", "file-2", ph));
		executorService.submit(new FileReaderThread("thread-3", "file-3", ph));

		// For main thread
		ph.arriveAndAwaitAdvance();
		System.out.println("New phase " + ph.getPhase() + " started");
		
		// Threads for second phase
		executorService.submit(new QueryThread("thread-1", 40, ph));
		executorService.submit(new QueryThread("thread-2", 40, ph));
		
		curPhase = ph.getPhase();
		ph.arriveAndAwaitAdvance();
		System.out.println("Phase " + curPhase + " completed");
		
		// deregistering the main thread
		ph.arriveAndDeregister();
	}
}
