package com.helpezee.lock;

import java.util.concurrent.locks.Lock;

public class Account implements Runnable {

	private static int balance = 1000;
	private Lock lock;

	public Account(Lock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {

		try {
			lock.lock();
			if (balance >= 800) {
				System.out.println(Thread.currentThread().getName()	+ " You have suffiecient balance to withdraw , your balance : Rs." + balance);
				Thread.sleep(2000);
				balance = balance - 800;
				System.out.println(Thread.currentThread().getName() + " Your balance after withdraw  : Rs." + balance);
			} else {
				System.out.println(Thread.currentThread().getName()	+ " You don't have suffiecient balance to withdraw , your balance : Rs." + balance);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}