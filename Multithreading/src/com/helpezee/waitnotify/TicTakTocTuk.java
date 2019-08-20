package com.helpezee.waitnotify;

class Clock {
	private int counter = 0;

	synchronized void printTic(String msg) {
		if (counter != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		counter++;
		notifyAll();
	}

	synchronized void printTac(String msg) {
		if (counter != 1 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		counter++;
		notifyAll();
	}

	synchronized void printToc(String msg) {
		if (counter != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		counter++;
		notifyAll();
	}
	
	synchronized void printTuk(String msg) {
		while (counter != 3) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		counter = 0;
		notifyAll();
	}
}

class TicTask implements Runnable {

	private Clock clock;

	public TicTask(Clock clock) {
		super();
		this.clock = clock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			clock.printTic("Tic");
		}
	}

}

class TacTask implements Runnable {

	private Clock clock;

	public TacTask(Clock clock) {
		super();
		this.clock = clock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			clock.printTac("Tac");
		}
	}

}

class TocTask implements Runnable {

	private Clock clock;

	public TocTask(Clock clock) {
		super();
		this.clock = clock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			clock.printToc("Toc");
		}
	}

}

class TukTask implements Runnable {

	private Clock clock;

	public TukTask(Clock clock) {
		super();
		this.clock = clock;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			clock.printToc("Tuk");
		}
	}

}

public class TicTakTocTuk {

	public static void main(String[] args) {
		Clock clock = new Clock();
		Thread t1 = new Thread(new TicTask(clock), "Tic");
		Thread t2 = new Thread(new TacTask(clock), "Tac");
		Thread t3 = new Thread(new TocTask(clock), "Toc");
		Thread t4 = new Thread(new TukTask(clock), "Tuk");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
